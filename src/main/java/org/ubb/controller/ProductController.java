package org.ubb.controller;

import org.ubb.domain.Product;
import org.ubb.repository.IRepository;
import org.ubb.service.ProductService;
import org.ubb.view.View;
import org.ubb.view.ViewMenuItems;

import java.util.InputMismatchException;

public class ProductController {

    private final View view;
    private final ProductService productService;

    public ProductController(View view, ProductService productService) {
        this.view = view;
        this.productService = productService;
    }

    public void selectedOption(ViewMenuItems selectedItem) {
        try {
            switch (selectedItem) {
                case PRINT_ALL:

                    break;

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


    }
}
