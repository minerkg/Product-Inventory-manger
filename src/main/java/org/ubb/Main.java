package org.ubb;

import org.ubb.controller.ProductController;
import org.ubb.domain.Product;
import org.ubb.repository.IRepository;
import org.ubb.repository.Repository;
import org.ubb.view.View;
import org.ubb.view.ViewMenuItems;

public class Main {
    public static void main(String[] args) {

        View view = new View();
        ProductController productController = new ProductController(view);
        IRepository<Long, Product> productRepository = new Repository();

        ViewMenuItems selectedItem = ViewMenuItems.PRINT_ALL;
        while (selectedItem != ViewMenuItems.EXIT) {
            selectedItem = view.runMenu();
            System.out.println(selectedItem);
            productController.selectedOption(selectedItem);
        }

    }
}