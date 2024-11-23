package org.ubb.service;

import org.ubb.domain.Product;
import org.ubb.repository.IRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ProductService {

    private final IRepository<Long, Product> productRepository;

    private List<Predicate<Product>> filtersApplied;

    public ProductService(IRepository<Long, Product> productRepository) {
        this.productRepository = productRepository;
        filtersApplied = new ArrayList<>();
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
                break;
            case "brand":
                productFilter = p -> p.getBrand().equals(attributeValue);
                break;
            case "availability":
                productFilter = p -> p.getAvailability().equals(attributeValue);
                break;
            default:
                productFilter = p -> true;
        }
        filtersApplied.add(productFilter);

        return this.fetchAll().stream()
                .filter(filtersApplied.stream().reduce(p -> true, Predicate::or))
                .collect(Collectors.toList());

    }
}
