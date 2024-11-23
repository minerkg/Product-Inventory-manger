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
        System.out.println(commandAndParams);

        String command = commandAndParams.split("\\s+")[0];

        String[] params = commandAndParams.split("\\s+");
        String[] parameters = new String[params.length-1];
        for (int i=1; i < params.length; i++)
           parameters[i - 1] = params[i];

        ViewMenuItems selectedItem = ViewMenuItems.valueOf(command.toUpperCase());
        selectedItem.setParams(parameters);

        return selectedItem;

    }



}
