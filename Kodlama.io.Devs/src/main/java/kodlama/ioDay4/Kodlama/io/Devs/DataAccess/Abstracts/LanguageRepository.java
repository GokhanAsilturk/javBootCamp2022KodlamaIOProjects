package kodlama.ioDay4.Kodlama.io.Devs.DataAccess.Abstracts;

import kodlama.ioDay4.Kodlama.io.Devs.Entities.Concretes.Language;

import java.util.List;



public interface LanguageRepository {

    void add(Language language) throws Exception;
    void delete(Language language);
    void update(Language language, String name, int id);
    List<Language> getAll();
    Language getFromId(int id);

    String getRepositoryName();

}
