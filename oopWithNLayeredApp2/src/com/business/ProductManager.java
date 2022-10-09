package com.business;

import com.core.logging.ILogger;
import com.dataAccess.IProductDao;
import com.dataAccess.JdbcProductDao;
import com.entities.Product;


import java.util.List;

public class ProductManager {
    //business rules

    private IProductDao productDao;
    //private List<ILogger> loggers; //bana bir logger listesi ver. array şeklinde verir
    private ILogger[] loggers;

    public ProductManager(IProductDao productDao, ILogger[] loggers) {
        this.productDao = productDao;
        this.loggers = loggers;
    }

    public void add(Product product) throws Exception {
        //throw fırlatmak demektir. hata mesajı vermek için de kullanılır.
        if (product.getUnitPrice() < 10) {
            throw new Exception("Ürün fiyatı 10 dan küçük olamaz.");
        }

        //interfaceler kendini implemente eden classları newleyebilir.
        //Bir katman başka bir katmanın classını kullanırken sadece interface inden erişim kurmalıdır!.
        //IProductDao productDao = new JdbcProductDao(); ama bu yanlış bir kullanımdır. bunun yerine product manager constructerına IproductDao interface nesnesi verip add bloğunda kullanabiliriz.
        productDao.add(product);

        for (ILogger logger : loggers) { // [db logger,mail logger,file logger]
            logger.log(product.getName());
        }

    }
}
