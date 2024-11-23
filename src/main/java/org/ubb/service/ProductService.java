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

    private List<Predicate<Product>> filtersApplied;
    private Map<FilterType, List<Predicate<Product>>> filtersAppliedByType;

    public ProductService(IRepository<Long, Product> productRepository) {
        this.productRepository = productRepository;
        filtersApplied = new ArrayList<>();
        filtersAppliedByType = new HashMap<>();
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
        Predicate<Product> productFilter;
        switch (attributeName) {
            case "name":
                productFilter = p -> p.getName().equals(attributeValue);
                List<Predicate<Product>> nameFilters = filtersAppliedByType.get(FilterType.NAME);
                nameFilters.add(productFilter);
                filtersAppliedByType.put(FilterType.NAME, nameFilters);
                break;
            case "brand":
                productFilter = p -> p.getBrand().equals(attributeValue);
                List<Predicate<Product>> brandFilters = filtersAppliedByType.get(FilterType.BRAND);
                brandFilters.add(productFilter);
                filtersAppliedByType.put(FilterType.BRAND, brandFilters);
                break;
            case "availability":
                productFilter = p -> p.getAvailability().equals(attributeValue);
                List<Predicate<Product>> availabilityFilters = filtersAppliedByType.get(FilterType.AVAILABILITY);
                availabilityFilters.add(productFilter);
                filtersAppliedByType.put(FilterType.AVAILABILITY, availabilityFilters);
                break;
            default:
                productFilter = p -> true;
        }

        return this.fetchAll().stream()
                .filter(filtersAppliedByType.get(FilterType.NAME).stream().reduce(p -> false, Predicate::or)
                        .and(filtersAppliedByType.get(FilterType.BRAND).stream().reduce(p -> false, Predicate::or))
                        .and(filtersAppliedByType.get(FilterType.AVAILABILITY).stream().reduce(p -> false, Predicate::or)))
                .collect(Collectors.toList());

    }
}
