package org.internship.market;

import org.internship.market.config.AppConfig;
import org.internship.market.database.dao.AccountingDAO;
import org.internship.market.database.entity.AccountingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.Date;

public class StartApp {

    public static void main(String[] args) throws InterruptedException, SQLException {

        System.out.println("This is the start of the PT Spring Hibernate application");
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        AccountingDAO accountingDAO = context.getBean(AccountingDAO.class);

      /*  AccountingEntity accountingEntity = new AccountingEntity(2.5 , 550, 800,  new Date());
        accountingDAO.save(accountingEntity);*/

        context.close();
    }
}
