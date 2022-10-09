package com.dataAccess;

import com.entities.Product;

public class HibernateProductDao implements IProductDao {

    public void add(Product product) {
        //sadece db erişim kodları buraya yazılır. SQL
        System.out.println("Hibernate ile veritabanına eklendi: " + product.getName());
    }
}
