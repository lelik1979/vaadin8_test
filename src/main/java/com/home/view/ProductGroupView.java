package com.home.view;

import com.home.model.ProductGroup;
import com.home.model.ProductGroupService;
import com.home.view.search.SearchPanel;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.events.EventBus;
import javax.annotation.PostConstruct;
import java.util.Objects;

@SpringView(name = ProductGroupView.VIEW_NAME)
public class ProductGroupView extends Panel implements View {

    private static final Logger LOG = LoggerFactory.getLogger(ProductGroupView.class);

    public static final String VIEW_NAME = "productGroupView";

    private ProductGroupGridModel productGroupGridModel;

    private final EventBus eventBus;

    @Autowired
    public ProductGroupView(ProductGroupService productGroupService, EventBus eventBus) {
        this.eventBus = Objects.requireNonNull(eventBus, "eventBus can't be null");
        Objects.requireNonNull(productGroupService, "productGroupService can't be null");
        this.productGroupGridModel = new ProductGroupGridModel(productGroupService);
        this.eventBus.subscribe(productGroupGridModel);
    }

    @PostConstruct
    void init() {
        VerticalLayout layout = new VerticalLayout();
        setContent(layout);
        addSearch(layout);
        addComponents(layout);
        setSizeFull();
    }

    private void addSearch(VerticalLayout layout) {
        SearchPanel searchPanel = new SearchPanel(eventBus);
        layout.addComponent(searchPanel);
    }

    private void addComponents(VerticalLayout layout) {
        Grid<ProductGroup> productGroupGrid = new ProductGroupGrid(productGroupGridModel);
        layout.addComponent(productGroupGrid);
        layout.setExpandRatio(productGroupGrid, 1);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        LOG.debug("{}", event.getSource());
    }
}