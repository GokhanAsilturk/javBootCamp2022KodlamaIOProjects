package kodlama.io.rentACar.DataAccess.Concretes;

import kodlama.io.rentACar.DataAccess.Abstracts.BrandRepository;
import kodlama.io.rentACar.Entities.Concretes.Brand;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository //Sen bir repository sin. (Bu sınıf bir Data Access nesnesidir)
public class InMemoryBrandRepository implements BrandRepository {

    List<Brand> brands;

    public InMemoryBrandRepository() {
        brands = new ArrayList<Brand>();
        brands.add(new Brand(1,"BMW"));
        brands.add(new Brand(2,"Audi"));
        brands.add(new Brand(3,"Mercedes"));
        brands.add(new Brand(4,"Renault"));
        brands.add(new Brand(5,"Dacia"));

    }

    @Override
    public void add(Brand brand) {
        brands.add(brand);
    }

    @Override
    public List<Brand> getAll() {
        return brands;
    }



}
