package com.home.view;

import com.home.model.ProductGroup;
import com.home.model.ProductGroupService;
import com.vaadin.data.provider.AbstractBackEndDataProvider;
import com.vaadin.data.provider.Query;
import org.vaadin.spring.events.Event;
import org.vaadin.spring.events.EventBusListener;
import java.util.stream.Stream;

public class ProductGroupGridModel
        extends AbstractBackEndDataProvider<ProductGroup, Void>
        implements EventBusListener<ProductGroupSearchEvent> {


    private ProductGroupService productGroupService;

    public ProductGroupGridModel(ProductGroupService productGroupService) {
        this.productGroupService = productGroupService;
    }

    @Override
    protected Stream<ProductGroup> fetchFromBackEnd(Query<ProductGroup, Void> query) {
        return productGroupService.findAll(query.getOffset(), query.getLimit());
    }

    @Override
    protected int sizeInBackEnd(Query<ProductGroup, Void> query) {
        return productGroupService.count();
    }

    @Override
    public void onEvent(Event<ProductGroupSearchEvent> event) {
        productGroupService.setFilter(event.getPayload().getSearchString());
        refreshAll();
    }
}
