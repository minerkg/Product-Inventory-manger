package org.ubb;

import org.ubb.controller.ProductController;
import org.ubb.view.View;
import org.ubb.view.ViewMenuItems;

public class Main {
    public static void main(String[] args) {

        View view = new View();
        ProductController productController = new ProductController(view);

        ViewMenuItems selectedItem = ViewMenuItems.PRINT_ALL;
        while (selectedItem != ViewMenuItems.EXIT) {
            selectedItem = view.runMenu();
            productController.selectedOption(selectedItem);
        }

    }
}