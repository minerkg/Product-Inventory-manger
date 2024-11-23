package org.ubb.view;

public enum ViewMenuItems {

    PRINT_ALL("print-all", 1),
    ADD("add", 2),
    DELETE("delete", 3),
    FILTER("filter", 4),
    REMOVE("remove", 5),
    EXIT("exit", 6);


    private final String label;
    private final int id;

    private ViewMenuItems(String shownName, int id) {
        this.label = shownName;
        this.id = id;
    }

    public String getLabel() {
        return "-- " + this.id + ". " + this.label;
    }
}
