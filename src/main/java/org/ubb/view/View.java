package org.ubb.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class View {


    private Scanner scanner;

    public View() {
        scanner = new Scanner(System.in);
    }

    public ViewMenuItems runMenu() {
        Arrays.stream(ViewMenuItems.values())
                .map(ViewMenuItems::getLabel)
                .forEach(System.out::println);

        String commandAndParams = scanner.nextLine();
        String command = commandAndParams.split("\\s+")[0];
        ViewMenuItems selectedItem = ViewMenuItems.valueOf(command.toUpperCase());

        if (commandAndParams.split("\\s+").length > 1) {
            String params = commandAndParams.split("\\s+")[1];
            String[] parameters = params.split(",");

            selectedItem.setParams(parameters);
        }

        return selectedItem;

    }



}
