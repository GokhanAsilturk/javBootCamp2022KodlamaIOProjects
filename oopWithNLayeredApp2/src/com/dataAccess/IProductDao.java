package com.dataAccess;

import com.entities.Product;

public interface IProductDao {
    void add(Product product);
    //product dao ile ilgili olan alternatifler(hibernate ve jdbc) bu imzayı içermek zorundadır.

}
