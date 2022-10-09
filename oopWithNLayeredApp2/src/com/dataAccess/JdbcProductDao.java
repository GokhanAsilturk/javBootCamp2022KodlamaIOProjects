package com.dataAccess;

import com.entities.Product;

public class JdbcProductDao implements IProductDao {
//dao=Data access object

    public void add(Product product) {
        //sadece db erişim kodları buraya yazılır. SQL
        System.out.println("JDBC ile veritabanına eklendi: " + product.getName());
    }
}


