package com.home.view;

import com.home.MenuItemClickListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MenuPanel extends VerticalLayout {

    public static final Logger LOG = LoggerFactory.getLogger(MenuPanel.class);


    public MenuPanel() {
        setSpacing(true);
        setMargin(true);
        initComponents();
    }

    private void initComponents() {
//        addLoginInfo();
        addComponent(new Button("Группы продуктов", new MenuItemClickListener(ProductGroupView.VIEW_NAME)));
//        addComponent(new Button("Товар", new MenuItemClickListener(ProductView.VIEW_NAME)));
//        addComponent(new Button("Заказы", new MenuItemClickListener(OrderView.VIEW_NAME)));
//        addComponent(new Button("Выход", new LogoutClickListener()));
    }

//    private void addLoginInfo() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String name = auth.getName(); //get logged in username
//        Label loginLabel = new Label("login : " + name);
//        addComponent(loginLabel);
//    }
}
