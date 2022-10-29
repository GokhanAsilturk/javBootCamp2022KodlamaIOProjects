package kodlama.io.rentACar.DataAccess.Abstracts;

import kodlama.io.rentACar.Entities.Concretes.Brand;


import java.util.List;


public interface BrandRepository {
    void add(Brand brand);
    List<Brand> getAll();



}
