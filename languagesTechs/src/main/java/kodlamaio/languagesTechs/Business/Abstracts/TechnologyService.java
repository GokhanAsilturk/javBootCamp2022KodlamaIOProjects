package kodlamaio.languagesTechs.Business.Abstracts;


import kodlamaio.languagesTechs.Business.Requests.TechnologyRequests.AddTechnologyRequest;
import kodlamaio.languagesTechs.Business.Requests.TechnologyRequests.DeleteTechnologyRequest;
import kodlamaio.languagesTechs.Business.Requests.TechnologyRequests.FindAllByLanguageIdRequest;
import kodlamaio.languagesTechs.Business.Requests.TechnologyRequests.UpdateTechnologyRequest;
import kodlamaio.languagesTechs.Business.Responses.TechnologyResponses.FindAllByLanguageIdResponse;
import kodlamaio.languagesTechs.Business.Responses.TechnologyResponses.GetAllTechnologyResponse;


import java.util.List;

public interface TechnologyService {

    public String add(AddTechnologyRequest addTechnologyRequest);
    public String delete(DeleteTechnologyRequest deleteLanguageRequest);
    public String update(UpdateTechnologyRequest updateTechnologyRequest);

    FindAllByLanguageIdResponse findAllByLanguageId(FindAllByLanguageIdRequest findAllByLanguageIdRequest);

    List<GetAllTechnologyResponse> getAll(String languageId);




}
