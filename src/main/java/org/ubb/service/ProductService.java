package org.ubb.service;

import org.ubb.domain.Product;
import org.ubb.repository.IRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ProductService {

    private final IRepository<Long, Product> productRepository;


    private final Map<FilterType, List<Predicate<Product>>> filtersAppliedByType;

    public ProductService(IRepository<Long, Product> productRepository) {
        this.productRepository = productRepository;
        filtersAppliedByType = new HashMap<>();
        List<Predicate<Product>> nameFilters = new ArrayList<>();
        List<Predicate<Product>> brandFilters = new ArrayList<>();
        List<Predicate<Product>> availabilityFilters = new ArrayList<>();
        filtersAppliedByType.put(FilterType.NAME, nameFilters);
        filtersAppliedByType.put(FilterType.BRAND, brandFilters);
        filtersAppliedByType.put(FilterType.AVAILABILITY, availabilityFilters);

    }

    public List<Product> fetchAll() {
        return StreamSupport.stream(productRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public void addProduct(String productName, String brand, String availability) {
        Product newProduct = new Product(productName, brand, availability);
        try {
            productRepository.save(newProduct);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    public void deleteProductById(Long id) {
        productRepository.delete(id);
    }

    public List<Product> filer(String attributeName, String attributeValue) {

        switch (attributeName) {
            case "name":
                Predicate<Product> nameFilter;
                nameFilter = p -> p.getName().equals(attributeValue);
                List<Predicate<Product>> nameFilters = filtersAppliedByType.get(FilterType.NAME);
                nameFilters.add(nameFilter);
                filtersAppliedByType.put(FilterType.NAME, nameFilters);
                break;
            case "brand":
                Predicate<Product> brandFilter;
                brandFilter = p -> p.getBrand().equals(attributeValue);
                List<Predicate<Product>> brandFilters = filtersAppliedByType.get(FilterType.BRAND);
                brandFilters.add(brandFilter);
                filtersAppliedByType.put(FilterType.BRAND, brandFilters);
                break;
            case "availability":
                Predicate<Product> availabilityFilter;
                availabilityFilter = p -> p.getAvailability().equals(attributeValue);
                List<Predicate<Product>> availabilityFilters = filtersAppliedByType.get(FilterType.AVAILABILITY);
                availabilityFilters.add(availabilityFilter);
                filtersAppliedByType.put(FilterType.AVAILABILITY, availabilityFilters);
                break;

        }

        return this.fetchAll().stream()
                .filter(filtersAppliedByType.get(FilterType.NAME).stream().reduce(p -> false, Predicate::or))
              //  .filter(filtersAppliedByType.get(FilterType.BRAND).stream().reduce(p -> false, Predicate::or))
               // .filter(filtersAppliedByType.get(FilterType.AVAILABILITY).stream().reduce(p -> false, Predicate::or))
                .collect(Collectors.toList());

    }
}
