package org.ubb;

import org.ubb.view.ViewMenuItems;

public class Main {
    public static void main(String[] args) {


        ViewMenuItems selectedItem = ViewMenuItems.FILTER_TRANSACTIONS;
        while (selectedItem != ViewMenuItems.EXIT) {
            selectedItem = bookStoreView.runMenu();
            bookStoreController.selectedOption(selectedItem);
        }

    }
}