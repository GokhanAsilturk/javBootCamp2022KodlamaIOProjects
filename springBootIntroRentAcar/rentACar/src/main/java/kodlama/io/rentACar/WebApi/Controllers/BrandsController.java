package kodlama.io.rentACar.WebApi.Controllers;


import kodlama.io.rentACar.Business.Abstracts.BrandService;
import kodlama.io.rentACar.Entities.Concretes.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //annotation = bilgilendirme ifadesidir. (Erişim noktası)
@RequestMapping("/api/brands") //Adresleme


@Service //IOC containera ekleyip, bir servis katmanı olarak newle
public class BrandsController {


    //---------------------API----------------

    private BrandService brandService;

    @Autowired //Constructor da ki parametrelere bak ve o interface i implemente eden Class ı bana newleyerek ver.
    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/addNewBrand")//Çağırma
    public void add(Brand brand) {
        brandService.add(brand);
    }

    @GetMapping("/getAllBrands") //Çağırma
    public List<Brand> getAll() {
        return brandService.getAll();
    }


}
