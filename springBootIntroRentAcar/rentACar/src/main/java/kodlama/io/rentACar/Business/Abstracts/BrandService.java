package kodlama.io.rentACar.Business.Abstracts;

import kodlama.io.rentACar.Entities.Concretes.Brand;

import java.util.List;

public interface BrandService {

    void add(Brand brand);
    List<Brand> getAll();

}
