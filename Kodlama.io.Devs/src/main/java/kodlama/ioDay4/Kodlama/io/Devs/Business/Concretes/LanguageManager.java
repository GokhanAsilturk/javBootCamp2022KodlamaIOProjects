package kodlama.ioDay4.Kodlama.io.Devs.Business.Concretes;

import kodlama.ioDay4.Kodlama.io.Devs.Business.Abstracts.LanguageService;
import kodlama.ioDay4.Kodlama.io.Devs.DataAccess.Abstracts.LanguageRepository;
import kodlama.ioDay4.Kodlama.io.Devs.Entities.Concretes.Language;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageManager implements LanguageService {


    private LanguageRepository languageRepository;

    public LanguageManager(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public String add(Language language) throws Exception {

        if (language.getName().isEmpty()) {
            throw new IllegalStateException("Language name cannot be empty! ");
        } else {
            for (Language tempLanguage : getAll()) {
                if (language.getName().toLowerCase().equals(tempLanguage.getName().toLowerCase())) {
                    throw new IllegalStateException("Language names cannot repeat!. " + language.getName() + " is same name: " + tempLanguage.getName());
                }
            }
        }
        languageRepository.add(language);
        return language.getName() + " added to " + languageRepository.getRepositoryName();
    }

    @Override
    public String delete(int id) {
        boolean situation = false;
        for (Language language : languageRepository.getAll()){

            if (id == language.getId()) {
                languageRepository.delete(language);
                situation = true;
                return language.getName() + " deleted from " + languageRepository.getRepositoryName();
            }

            if(languageRepository.getAll().size() == languageRepository.getAll().indexOf(language)){
                throw new IllegalStateException("");
            }

        }
return null;
    }

    @Override
    public String update(Language language, String name, int id) {
        if (language.getName().isEmpty()) {
            throw new IllegalStateException("Language name cannot be empty! ");
        }else{
            languageRepository.update(language, name, id);
        }
        return language.getName() + " updated on " + languageRepository.getRepositoryName();
    }

    @Override
    public List<Language> getAll() {
        return languageRepository.getAll();
    }

    @Override
    public Language getFromId(int id) {

        return languageRepository.getFromId(id);
    }
}
