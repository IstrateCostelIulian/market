package org.internship.market;

import org.internship.market.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class StartApp {
    public static void main(String[] args) throws InterruptedException, SQLException {
        System.out.println("This is the start of the PT Spring Hibernate application");
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        context.close();
    }
}
