package com.home.view;

import com.home.model.ProductGroup;
import com.vaadin.ui.Grid;

public class ProductGroupGrid extends Grid<ProductGroup> {

    public ProductGroupGrid(ProductGroupGridModel productGroupGridModel) {
        setDataProvider(productGroupGridModel);
        init();
    }

    private void init() {
        setSelectionMode(Grid.SelectionMode.SINGLE);
        setSizeFull();
        addColumn(ProductGroup::getId)
            .setCaption(ProductGroup.ID_PROPERTY_NAME)
            .setMinimumWidth(60);
        addColumn(ProductGroup::getName)
            .setCaption(ProductGroup.NAME_PROPERTY_NAME)
            .setExpandRatio(1);

    }
}
