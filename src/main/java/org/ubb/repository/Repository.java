package org.ubb.repository;

import org.ubb.domain.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

public class Repository implements IRepository<Long, Product>{

    private final Connection connection;
    private String url = "jdbc:postgresql://localhost:5432/products-java-app";

    private String user = "postgres";
    private String passwor = System.getenv("postgres_pass");


    public Repository() {

        try {
            this.connection = DriverManager.getConnection(url, user, passwor);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
