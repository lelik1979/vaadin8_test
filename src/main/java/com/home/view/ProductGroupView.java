package com.home.view;

import com.home.model.ProductGroup;
import com.home.model.ProductGroupService;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.Objects;

@SpringView(name = ProductGroupView.VIEW_NAME)
public class ProductGroupView extends Panel implements View {

    private static final Logger LOG = LoggerFactory.getLogger(ProductGroupView.class);

    public static final String VIEW_NAME = "productGroupView";

    private ProductGroupService productGroupService;

    @Autowired
    public ProductGroupView(ProductGroupService productGroupService) {
        this.productGroupService = Objects.requireNonNull(productGroupService, "productGroupService can't be null");
    }

    @PostConstruct
    void init() {
        VerticalLayout layout = new VerticalLayout();
        setContent(layout);
        addComponents(layout);
        setSizeFull();
    }

    private void addComponents(VerticalLayout layout) {
        Grid<ProductGroup> productGroupGrid = new Grid<>("ProductGroup", new ProductGroupGridModel(productGroupService));
        productGroupGrid.setSelectionMode(Grid.SelectionMode.SINGLE);
        productGroupGrid.setSizeFull();
        productGroupGrid
                .addColumn(ProductGroup::getId)
                .setCaption(ProductGroup.ID)
                .setMinimumWidth(60);
        productGroupGrid
                .addColumn(ProductGroup::getName)
                .setCaption(ProductGroup.NAME)
                .setExpandRatio(1);
        layout.addComponent(productGroupGrid);
        layout.setExpandRatio(productGroupGrid, 1);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        LOG.debug("{}", event.getSource());
    }
}