package kodlamaio.languagesTechs.api.controllers;


import kodlamaio.languagesTechs.Business.Abstracts.LanguageService;
import kodlamaio.languagesTechs.Business.Requests.LanguageRequests.AddLanguageRequest;
import kodlamaio.languagesTechs.Business.Requests.LanguageRequests.DeleteLanguageRequest;
import kodlamaio.languagesTechs.Business.Requests.LanguageRequests.FindByLanguageNameRequest;
import kodlamaio.languagesTechs.Business.Requests.LanguageRequests.UpdateLanguageRequest;
import kodlamaio.languagesTechs.Business.Responses.LanguageResponses.GetAllLanguagesResponse;
import kodlamaio.languagesTechs.Entities.Concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/language")

@Service
public class LanguageController {

private LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }





    @GetMapping("/getAll")
    public List<GetAllLanguagesResponse> getAll(){
    return languageService.getAll();
    }


    @PostMapping("/add")
    public String add(@RequestBody AddLanguageRequest addLanguageRequest) {
    return languageService.add(addLanguageRequest);
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody DeleteLanguageRequest deleteLanguageRequest) {


        return languageService.delete(deleteLanguageRequest);
    }

    @PutMapping("/update")
    public String update(@RequestBody UpdateLanguageRequest updateLanguageRequest){
    return languageService.update(updateLanguageRequest);
    }

    @GetMapping("/findByName")
    public Language findByName(@RequestBody FindByLanguageNameRequest findByLanguageNameRequest){
        return languageService.findByName(findByLanguageNameRequest.getName());
    }




}
