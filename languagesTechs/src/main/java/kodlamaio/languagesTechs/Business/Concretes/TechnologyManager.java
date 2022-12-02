package kodlamaio.languagesTechs.Business.Concretes;

import kodlamaio.languagesTechs.Business.Abstracts.LanguageService;
import kodlamaio.languagesTechs.Business.Requests.TechnologyRequests.FindAllByLanguageIdRequest;
import kodlamaio.languagesTechs.Business.Responses.TechnologyResponses.FindAllByLanguageIdResponse;
import kodlamaio.languagesTechs.DataAccess.Abstracts.LanguageRepository;
import kodlamaio.languagesTechs.Business.Abstracts.TechnologyService;
import kodlamaio.languagesTechs.Business.Requests.TechnologyRequests.AddTechnologyRequest;
import kodlamaio.languagesTechs.Business.Requests.TechnologyRequests.DeleteTechnologyRequest;
import kodlamaio.languagesTechs.Business.Requests.TechnologyRequests.UpdateTechnologyRequest;
import kodlamaio.languagesTechs.Business.Responses.TechnologyResponses.GetAllTechnologyResponse;
import kodlamaio.languagesTechs.DataAccess.Abstracts.TechnologiesRepository;
import kodlamaio.languagesTechs.Entities.Concretes.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TechnologyManager implements TechnologyService {


    private TechnologiesRepository technologyRepository;
    private LanguageService languageService;

    private LanguageRepository languageRepository;


    @Autowired
    public TechnologyManager(TechnologiesRepository technologyRepository, LanguageService languageService, LanguageRepository languageRepository) {
        this.technologyRepository = technologyRepository;
        this.languageService = languageService;
        this.languageRepository = languageRepository;
    }

    @Override
    public String add(AddTechnologyRequest addTechnologyRequest) {

        Technology technology = new Technology();

        technology.setLanguage(this.languageRepository.findById(addTechnologyRequest.getLanguageId()).get());
        technology.setName(addTechnologyRequest.getName());
        this.technologyRepository.save(technology);

        return "New " + technology.getLanguage().getName() + " technology added to database: " + technology.getName();
    }

    @Override
    public String delete(DeleteTechnologyRequest deleteTechnologyRequest) {

        String deletedTechnology = this.technologyRepository.findById(deleteTechnologyRequest.getId()).get().getName();
        this.technologyRepository.delete(this.technologyRepository.findById(deleteTechnologyRequest.getId()).get());


        return "Technology deleted from database: " + deletedTechnology;
    }

    @Override
    public String update(UpdateTechnologyRequest updateTechnologyRequest) {

        if (updateTechnologyRequest.getNewTechName().equals(technologyRepository.findById(updateTechnologyRequest.getId()).get().getName())) {
            return "Technology is already on DB: " + updateTechnologyRequest.getNewTechName();
        }

        Technology inDBTechnologyItem = this.technologyRepository.findById(updateTechnologyRequest.getId()).get();
        inDBTechnologyItem.setName(updateTechnologyRequest.getNewTechName());

        return "Technology updated: " + technologyRepository.save(inDBTechnologyItem).getName();


    }

    @Override
    public FindAllByLanguageIdResponse findAllByLanguageId(FindAllByLanguageIdRequest findAllByLanguageIdRequest) {


        List<Technology> technologiesInDB = this.languageRepository.findById(findAllByLanguageIdRequest.getId()).get().getTechnologies();
        FindAllByLanguageIdResponse responseItem = new FindAllByLanguageIdResponse();


        responseItem.setTechnologies(technologiesInDB);
        responseItem.setLanguageName(this.languageRepository.findById(findAllByLanguageIdRequest.getId()).get().getName());


        return responseItem;
    }

    @Override
    public List<GetAllTechnologyResponse> getAll(String languageId) {



        if (!languageId.isBlank()) {
            int languageID = Integer.parseInt(languageId);
            List<Technology> technologiesInDB = this.technologyRepository.findAllByLanguage_Id(languageID);
            return GetAllTechnologyResponse.createTechnologyResponseList(technologiesInDB);
        }


        return GetAllTechnologyResponse.createTechnologyResponseList(this.technologyRepository.findAll());
    }






}
