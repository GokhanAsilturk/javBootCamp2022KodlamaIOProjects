package kodlamaio.languagesTechs.api.controllers;


import kodlamaio.languagesTechs.Business.Abstracts.TechnologyService;
import kodlamaio.languagesTechs.Business.Requests.TechnologyRequests.AddTechnologyRequest;
import kodlamaio.languagesTechs.Business.Requests.TechnologyRequests.DeleteTechnologyRequest;

import kodlamaio.languagesTechs.Business.Requests.TechnologyRequests.UpdateTechnologyRequest;

import kodlamaio.languagesTechs.Business.Responses.TechnologyResponses.GetAllTechnologyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technology")

@Service
public class TechnologiesController  {

    TechnologyService technologyService;

    @Autowired
    public TechnologiesController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @PostMapping("/add")
    public String add(@RequestBody AddTechnologyRequest addTechnologyRequest){
    return technologyService.add(addTechnologyRequest);
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody DeleteTechnologyRequest deleteLanguageRequest){
    return technologyService.delete(deleteLanguageRequest);
    }

    @PutMapping("/update")
    public String update(@RequestBody UpdateTechnologyRequest updateTechnologyRequest){
    return technologyService.update(updateTechnologyRequest);
    }

    @GetMapping("/getAll")
    List<GetAllTechnologyResponse> getAll(@RequestParam(defaultValue = "", name = "languageId") String languageId){

        return technologyService.getAll(languageId);
    }


}
