package com.travelplatform.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ContextInitialized..Web应用正在启动");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ContextDestroyed..Web应用正在销毁");
    }
}
