package com.zph.demo;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.zph.demo.services.ThriftServer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class App implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("contextInitialized");
        System.out.println(servletContextEvent.getServletContext().toString());
        try {
            WebApplicationContext beanFactory = WebApplicationContextUtils
                    .getRequiredWebApplicationContext(servletContextEvent.getServletContext());

            ThriftServer service = new ThriftServer(beanFactory);
            service.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("contextDestroyed");
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
