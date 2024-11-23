package org.ubb.repository;

import org.ubb.domain.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Repository implements IRepository<Long, Product> {

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
        Connection connection = null;
        List<Product> productList = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(url, user, passwor);
            String sql = "SELECT * FROM products";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String brand = resultSet.getString("brand");
                String availability = resultSet.getString("availability");
                Product newProduct = new Product(id, name, brand, availability);
                productList.add(newProduct);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return productList;
    }

    @Override
    public Optional<Product> save(Product entity) throws Exception {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, passwor);
            String sql = "INSERT INTO products (name ,brand , availability) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

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
