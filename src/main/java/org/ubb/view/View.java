package org.ubb.view;

import java.util.Arrays;
import java.util.Scanner;

public class View {


    private Scanner scanner;

    public View() {
        scanner = new Scanner(System.in);
    }

    public ViewMenuItems runMenu() {
        Arrays.stream(ViewMenuItems.values())
                .map(ViewMenuItems::getLabel)
                .forEach(System.out::println);

        String command = scanner.next();

        //ViewMenuItems selectedOption = ViewMenuItems.values()[scanner.nextInt() - 1];

        return ViewMenuItems.valueOf(command.toUpperCase());

    }



}
