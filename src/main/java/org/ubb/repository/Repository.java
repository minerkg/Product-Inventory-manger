package org.ubb.repository;

import org.ubb.domain.Product;

import java.util.Optional;

public class Repository implements IRepository<Long, Product>{


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
