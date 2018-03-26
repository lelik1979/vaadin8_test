package com.home.view;

import com.home.model.ProductGroup;
import com.home.model.ProductGroupService;
import com.vaadin.data.provider.AbstractBackEndDataProvider;
import com.vaadin.data.provider.Query;
import java.util.stream.Stream;


public class ProductGroupGridModel extends AbstractBackEndDataProvider<ProductGroup, Void> {

    private ProductGroupService productGroupService;

    public ProductGroupGridModel(ProductGroupService productGroupService) {
        this.productGroupService = productGroupService;
    }

    @Override
    protected Stream<ProductGroup> fetchFromBackEnd(Query<ProductGroup, Void> query) {
        return productGroupService.findAll(query.getOffset(), query.getLimit()).stream();
    }

    @Override
    protected int sizeInBackEnd(Query<ProductGroup, Void> query) {
        return productGroupService.count();
    }
}
