package com.home.view.search;

import com.vaadin.data.ValidationException;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.vaadin.spring.events.EventBus;

public class SearchPanel extends Panel {

    public static final Logger LOG = LoggerFactory.getLogger(SearchPanel.class);

    SearchFieldsBinder searchFieldsBinder;

    ProductGroupSearchEvent searchModel = new ProductGroupSearchEvent("");
    private EventBus eventBus;

    public SearchPanel(EventBus eventBus) {
        this.eventBus = eventBus;
        HorizontalLayout layout = new HorizontalLayout();
        setContent(layout);
        initComponents(layout);
    }

    private void initComponents(Layout layout) {
        addTextSearch(layout);
        addButton(layout);
    }

    private void addButton(Layout layout) {
        Button searchButton = new Button("Поиск");
        searchButton.addClickListener(event -> {
            try {
                searchFieldsBinder.writeBean(searchModel);
                eventBus.publish(this, (searchModel));
            } catch (ValidationException ex) {
                LOG.warn("Couldn't bind data ", ex);
            }
        });
        layout.addComponent(searchButton);
    }

    private void addTextSearch(Layout layout) {
        com.vaadin.ui.TextField textField = new TextField("Search text");
        searchFieldsBinder = new SearchFieldsBinder(searchModel, textField);
        layout.addComponent(textField);
    }
}
