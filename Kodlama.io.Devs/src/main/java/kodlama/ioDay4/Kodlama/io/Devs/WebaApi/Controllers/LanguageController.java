package kodlama.ioDay4.Kodlama.io.Devs.WebaApi.Controllers;

import kodlama.ioDay4.Kodlama.io.Devs.Business.Abstracts.LanguageService;
import kodlama.ioDay4.Kodlama.io.Devs.Entities.Concretes.Language;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/languages")


@Service
public class LanguageController {

    private LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/getAllLanguages")
    public List<Language> getAllLanguages() {
        return languageService.getAll();
    }



    @PostMapping("/addNewLanguage")
    public String add(@RequestBody Language language) throws Exception {
        return languageService.add(language);
    }



    @GetMapping("/getById/{id}")
    public Language getById(@PathVariable ("id") int id){
        return languageService.getFromId(id);
    }

    @DeleteMapping("/deleteLanguage/{id}")
    public String deleteLanguage(@PathVariable("id") int id){
       return languageService.delete(id);
    }

    @PutMapping("/updateLanguage/{name}/{id}")
    public void updateLanguage(@RequestBody Language language, @PathVariable("name") String name, @PathVariable("id") int id){
        languageService.update(language,name,id);
    }


}
