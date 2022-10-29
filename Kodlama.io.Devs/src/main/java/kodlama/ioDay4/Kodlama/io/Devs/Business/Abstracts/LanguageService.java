package kodlama.ioDay4.Kodlama.io.Devs.Business.Abstracts;

import kodlama.ioDay4.Kodlama.io.Devs.Entities.Concretes.Language;

import java.util.List;

public interface LanguageService {

    String add(Language language) throws Exception;
    String delete(int id);
    String update(Language language, String name, int id);
    List<Language> getAll();
    Language getFromId(int id);


}
