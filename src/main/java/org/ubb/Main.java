package org.ubb;

import org.ubb.controller.ProductController;
import org.ubb.domain.Product;
import org.ubb.repository.IRepository;
import org.ubb.repository.Repository;
import org.ubb.service.ProductService;
import org.ubb.view.View;
import org.ubb.view.ViewMenuItems;

public class Main {
    public static void main(String[] args) {

        View view = new View();
        IRepository<Long, Product> productRepository = new Repository();
        ProductService productService = new ProductService(productRepository);
        ProductController productController = new ProductController(view , productService);


        ViewMenuItems selectedItem = ViewMenuItems.PRINT_ALL;
        while (selectedItem != ViewMenuItems.EXIT) {
            selectedItem = view.runMenu();
            System.out.println(selectedItem);
            productController.selectedOption(selectedItem);
        }

    }
}