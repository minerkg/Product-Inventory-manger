package org.ubb.controller;

import org.ubb.domain.Product;
import org.ubb.service.ProductService;
import org.ubb.view.View;
import org.ubb.view.ViewMenuItems;

import java.util.List;

public class ProductController {

    private final View view;
    private final ProductService productService;

    private List<Product> productList;

    public ProductController(View view, ProductService productService) {
        this.view = view;
        this.productService = productService;
    }

    public void selectedOption(ViewMenuItems selectedItem) {
        try {
            switch (selectedItem) {
                case PRINT_ALL:
                    productList = productService.fetchAll();
                    productList.forEach(System.out::println);
                    break;
                case ADD:
                    String name = selectedItem.getParams()[0];
                    String brand = selectedItem.getParams()[1];
                    String availability = selectedItem.getParams()[2];
                    productService.addProduct(name, brand, availability);
                    break;
                case DELETE:
                    Long id = Long.parseLong(selectedItem.getParams()[0]);
                    productService.deleteProductById(id);
                    break;
                case FILTER:
                    String attributeName = selectedItem.getParams()[0];
                    String attributeValue = selectedItem.getParams()[1];
                    productList = productService.filer(productList, attributeName, attributeValue);
                    break;

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


    }
}
