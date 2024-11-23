package org.ubb.controller;

import org.ubb.view.View;
import org.ubb.view.ViewMenuItems;

import java.util.InputMismatchException;

public class ProductController {

    private final View view;

    public ProductController(View view) {
        this.view = view;
    }

    public void selectedOption(ViewMenuItems selectedItem) {
        try {
            switch (selectedItem) {
                case ViewMenuItems.PRINT_ALL:
                    System.out.println("you selected print");
                    break;

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


    }
}
