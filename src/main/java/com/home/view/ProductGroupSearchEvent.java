package com.home.view;

public class ProductGroupSearchEvent {

    private String searchString;

    public ProductGroupSearchEvent(String searchString) {
        this.searchString = searchString;
    }

    public String getSearchString() {
        return searchString;
    }
}
