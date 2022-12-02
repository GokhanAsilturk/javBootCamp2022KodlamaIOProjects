package kodlamaio.languagesTechs.Business.Concretes;

import kodlamaio.languagesTechs.Business.Abstracts.LanguageService;
import kodlamaio.languagesTechs.Business.Requests.LanguageRequests.AddLanguageRequest;
import kodlamaio.languagesTechs.Business.Requests.LanguageRequests.DeleteLanguageRequest;
import kodlamaio.languagesTechs.Business.Requests.LanguageRequests.UpdateLanguageRequest;
import kodlamaio.languagesTechs.Business.Responses.LanguageResponses.GetAllLanguagesResponse;
import kodlamaio.languagesTechs.DataAccess.Abstracts.LanguageRepository;
import kodlamaio.languagesTechs.Entities.Concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LanguageManager implements LanguageService {


    private LanguageRepository languageRepository;

    @Autowired
    public LanguageManager(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public String add(AddLanguageRequest addLanguageRequest) {

        if (addLanguageRequest.getName().isEmpty()) {
            return "Language name cannot be empty! ";
        }

        Language language = new Language();
        language.setName(addLanguageRequest.getName());

        this.languageRepository.save(language);

        return "New language added to database: " + language.getName();
    }

    @Override
    public String delete(DeleteLanguageRequest deleteLanguageRequest) {

        String deletedLanguageName = this.languageRepository.findById(deleteLanguageRequest.getId()).get().getName();


        if (deletedLanguageName.isEmpty()) {
            return ("Language not founded!: " + deletedLanguageName);
        }

        this.languageRepository.delete(this.languageRepository.findById(deleteLanguageRequest.getId()).get());

        return "Language deleted from database: " + deletedLanguageName;
    }

    @Override
    public String update(UpdateLanguageRequest updateLanguageRequest) {

        if (updateLanguageRequest.getNewLanguageName().isEmpty()) {
            return ("Language not founded!: " + updateLanguageRequest.getNewLanguageName());
        }

        Optional<Language> optionalLanguage = languageRepository.findById(updateLanguageRequest.getId());

        String languageNameInDB = "";

        if (optionalLanguage.isPresent()) {
            Language language = optionalLanguage.get();
            languageNameInDB = language.getName();
            language.setName(updateLanguageRequest.getNewLanguageName());
            this.languageRepository.save(language);
        }else{
            return "This language cannot founded! : " + languageNameInDB;
        }


        return "Language updated: " + languageNameInDB + " = " + updateLanguageRequest.getNewLanguageName();
    }

    @Override
    public List<GetAllLanguagesResponse> getAll() {

        List<Language> languages = languageRepository.findAll();
        List<GetAllLanguagesResponse> languagesResponse = new ArrayList<GetAllLanguagesResponse>();


        for (Language language : languages) {
            GetAllLanguagesResponse responseItem = new GetAllLanguagesResponse();
            responseItem.setId(language.getId());
            responseItem.setName(language.getName());

            languagesResponse.add(responseItem);
        }


        return languagesResponse;
    }

    @Override
    public Language findByName(String name) {

        if (name.isEmpty()) {
            throw new IllegalStateException("Language name cannot be empty!");
        }
        return this.languageRepository.findByName(name);
    }


}
