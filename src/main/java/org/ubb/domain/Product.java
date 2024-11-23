package org.ubb.domain;

public class Product {


    private Long id;
    private String brand;
    private String name;
    private String availability;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public Product(Long id, String brand, String name, String availability) {
        this.id = id;
        this.brand = brand;
        this.availability = availability;
        this.name = name;
    }
}
