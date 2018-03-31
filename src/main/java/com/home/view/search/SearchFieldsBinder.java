package com.home.view.search;

import com.vaadin.data.Binder;
import com.vaadin.data.HasValue;

public class SearchFieldsBinder extends Binder<ProductGroupSearchEvent> {

    public SearchFieldsBinder(
            ProductGroupSearchEvent searchEvent,
            HasValue<String> searchTextField) {
        forField(searchTextField)
                .withValidator(value ->
                            value.length() == 0 ||
                            Integer.valueOf(value) > 0
                            ,
                        "Search must be positive integer values"
                )
                .bind(ProductGroupSearchEvent::getSearchString, ProductGroupSearchEvent::setSearchString);
        readBean(searchEvent);
    }
}
