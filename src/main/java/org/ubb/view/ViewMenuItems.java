package org.ubb.view;

import java.util.List;

public enum ViewMenuItems {

    PRINT_ALL("print_all", 1),
    ADD("add", 2),
    DELETE("delete", 3),
    FILTER("filter", 4),
    REMOVE("remove", 5),
    EXIT("exit", 6);


    private List<String> params;
    private final String label;
    private final int id;

    private ViewMenuItems(String shownName, int id) {
        this.label = shownName;
        this.id = id;
    }

    public String getLabel() {
        return "-- " + this.id + ". " + this.label;
    }

    public List<String> getParams() {
        return params;
    }

    public void setParams(List<String> params) {
        this.params = params;
    }
}
