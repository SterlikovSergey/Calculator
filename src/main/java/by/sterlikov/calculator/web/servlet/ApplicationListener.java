package by.sterlikov.calculator.web.servlet;

import lombok.SneakyThrows;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener

public class ApplicationListener implements ServletContextListener {
    @SneakyThrows
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }
}
