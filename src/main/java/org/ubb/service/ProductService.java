package org.ubb.service;

import org.ubb.domain.Product;
import org.ubb.repository.IRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ProductService {

    private final IRepository<Long, Product> productRepository;

    public ProductService(IRepository<Long, Product> productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> printAll() {
        return StreamSupport.stream(productRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }


}
