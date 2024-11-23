package org.ubb.view;

import java.util.Arrays;
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
        System.out.println(command);

        //ViewMenuItems selectedOption = ViewMenuItems.values()[scanner.nextInt() - 1];

        return ViewMenuItems.valueOf(command.toUpperCase());

    }



}
