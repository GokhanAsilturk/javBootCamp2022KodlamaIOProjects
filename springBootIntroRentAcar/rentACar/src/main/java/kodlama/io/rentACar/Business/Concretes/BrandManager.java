package kodlama.io.rentACar.Business.Concretes;

import kodlama.io.rentACar.Business.Abstracts.BrandService;
import kodlama.io.rentACar.DataAccess.Abstracts.BrandRepository;
import kodlama.io.rentACar.Entities.Concretes.Brand;
import org.springframework.stereotype.Service;

import java.util.List;

@Service// Bu Sınıf bir Business nesnesidir.
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;

    public BrandManager(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public void add(Brand brand) {
        brandRepository.add(brand);
    }

    @Override
    public List<Brand> getAll() {

        return brandRepository.getAll();
    }





}
