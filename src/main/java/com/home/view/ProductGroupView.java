package com.home.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

@SpringView(name = ProductGroupView.VIEW_NAME)
public class ProductGroupView extends Panel implements View {

    private static final Logger LOG = LoggerFactory.getLogger(ProductGroupView.class);

    public static final String VIEW_NAME = "productGroupView";

    private VerticalLayout layout;

    @PostConstruct
    void init() {
        initLayout();
        addComponents();
        setSizeFull();
    }

    private void addComponents() {
//        ProductGroupTreeTable table = new ProductGroupTreeTable(productGroupWindowModel.getProductGroupTableModel());
        layout.addComponent(new Label("sdsd"));
    }

    private void initLayout() {
        layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        LOG.debug("ssdsds");
    }
}