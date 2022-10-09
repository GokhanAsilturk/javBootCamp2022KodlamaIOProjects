package com;

import com.business.ProductManager;
import com.core.logging.DatabaseLogger;
import com.core.logging.FileLogger;
import com.core.logging.ILogger;
import com.core.logging.MailLogger;
import com.dataAccess.JdbcProductDao;
import com.entities.Product;

public class Main {

    public static void main(String[] args) throws Exception {

        Product product1 = new Product(1, "Iphone SE3", 10000);

        ILogger[] loggers = {new DatabaseLogger(), new MailLogger(), new FileLogger()};

        ProductManager productManager = new ProductManager(new JdbcProductDao(), loggers);
        productManager.add(product1);

    }
}
