package com.home.view.search;

public class ProductGroupSearchEvent {

    private String searchString;

    public ProductGroupSearchEvent(String searchString) {
        this.searchString = searchString;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }
}
