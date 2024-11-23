package org.ubb.repository;

import org.ubb.domain.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Optional;

public class Repository implements IRepository<Long, Product>{

    private final Connection connection;


    public Repository() {
        this.connection = DriverManager.getConnection();
    }

    @Override
    public Optional<Product> findOne(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Iterable<Product> findAll() {
        return null;
    }

    @Override
    public Optional<Product> save(Product entity) throws Exception {
        return Optional.empty();
    }

    @Override
    public Optional<Product> delete(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Optional<Product> update(Product entity) throws Exception {
        return Optional.empty();
    }
}
