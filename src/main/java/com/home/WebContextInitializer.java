package com.home;

import com.vaadin.spring.server.SpringVaadinServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextCleanupListener;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebContextInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(javax.servlet.ServletContext servletContext)
            throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(SpringConfiguration.class);
        registerSpringContextLoaderListener(servletContext, context);
        registerServlet(servletContext);
    }

    private void registerServlet(ServletContext servletContext) {
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
                "vaadin", SpringVaadinServlet.class);
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/admin/*", "/VAADIN/*");
    }

    private void registerSpringContextLoaderListener(
            ServletContext servletContext,
            AnnotationConfigWebApplicationContext rootContext) {
        servletContext.addListener(new ContextLoaderListener(rootContext));
        servletContext.addListener(new ContextCleanupListener());
        servletContext.addListener(new RequestContextListener());
    }
}
