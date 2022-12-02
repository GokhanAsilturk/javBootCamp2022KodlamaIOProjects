package kodlamaio.languagesTechs.Business.Abstracts;

import kodlamaio.languagesTechs.Business.Requests.LanguageRequests.AddLanguageRequest;
import kodlamaio.languagesTechs.Business.Requests.LanguageRequests.DeleteLanguageRequest;
import kodlamaio.languagesTechs.Business.Requests.LanguageRequests.UpdateLanguageRequest;
import kodlamaio.languagesTechs.Business.Responses.LanguageResponses.GetAllLanguagesResponse;
import kodlamaio.languagesTechs.Entities.Concretes.Language;


import java.util.List;

public interface LanguageService {

    public String add(AddLanguageRequest addLanguageRequest);
    public String delete(DeleteLanguageRequest deleteLanguageRequest);
    public String update(UpdateLanguageRequest updateLanguageRequest);

    List<GetAllLanguagesResponse> getAll();

    public Language findByName(String name);
}
