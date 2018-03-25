package com.home;

import com.home.view.ContextPanel;
import com.home.view.ProductGroupView;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.Viewport;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.UI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
@SpringUI
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Viewport("user-scalable=no,initial-scale=1.0")
@Title("Админстрирование Beads")
public class MyUI extends UI  {

    public static final Logger LOG = LoggerFactory.getLogger(MyUI.class);

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setSizeFull();
        HorizontalSplitPanel layout = new HorizontalSplitPanel();
//        layout.setFirstComponent(new MenuPanel());
        layout.setSplitPosition(15, Unit.PERCENTAGE);
        ContextPanel cp = new ContextPanel();
        layout.setSecondComponent(cp);
        layout.setSizeFull();
        initNavigator(cp);
        setContent(layout);
    }

    private void initNavigator(ContextPanel cp) {
        Navigator navigator = new Navigator(this, cp);
        navigator.addView(ProductGroupView.VIEW_NAME, ProductGroupView.class);
//        navigator.addView(ProductView.VIEW_NAME, ProductView.class);
//        navigator.addView(OrderView.VIEW_NAME, OrderView.class);
        navigator.addView("", ContextPanel.class);
    }

}
