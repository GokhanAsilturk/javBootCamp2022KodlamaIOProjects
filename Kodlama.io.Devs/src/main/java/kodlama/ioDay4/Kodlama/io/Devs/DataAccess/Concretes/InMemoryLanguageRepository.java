package kodlama.ioDay4.Kodlama.io.Devs.DataAccess.Concretes;

import kodlama.ioDay4.Kodlama.io.Devs.DataAccess.Abstracts.LanguageRepository;
import kodlama.ioDay4.Kodlama.io.Devs.Entities.Abstracts.Entity;
import kodlama.ioDay4.Kodlama.io.Devs.Entities.Concretes.Language;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository {


    List<Language> languages;


    public InMemoryLanguageRepository() {
        languages = new ArrayList<Language>();
        languages.add(new Language("C#",1));
        languages.add(new Language("Java",2));
        languages.add(new Language("Python",3));
        languages.add(new Language("Kotlin",4));

    }

    @Override
    public void add(Language language) {
    languages.add(language);
    }

    @Override
    public void delete(Language language) {
    languages.remove(language);

    }

    @Override
    public void update(Language language, String name, int id) {
        Language updated = new Language(name,id);
    languages.set(languages.indexOf(language),updated);


    }

    @Override
    public List<Language> getAll() {
        return languages;
    }

    @Override
    public Language getFromId(int id) {

        for(Language language : languages){
            if(language.getId() == id){
                return language;
            }
        }

        return null;
    }

    @Override
    public String getRepositoryName() {
        return "in memory";
    }

}
