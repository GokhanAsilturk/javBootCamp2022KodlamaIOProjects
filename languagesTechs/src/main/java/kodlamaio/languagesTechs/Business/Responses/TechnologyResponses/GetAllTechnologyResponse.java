package kodlamaio.languagesTechs.Business.Responses.TechnologyResponses;


import kodlamaio.languagesTechs.Entities.Concretes.Technology;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllTechnologyResponse {
    private int id;
    private String name;
    private String languageName;


    public static List<GetAllTechnologyResponse> createTechnologyResponseList(List<Technology> technologies) {


        List<GetAllTechnologyResponse> responseList = new ArrayList<GetAllTechnologyResponse>();


        for (Technology technology : technologies) {


            responseList.add(createTechnologyResponse(technology));
        }
        return responseList;
    }



    private static GetAllTechnologyResponse createTechnologyResponse(Technology technology) {


        GetAllTechnologyResponse responseItem = new GetAllTechnologyResponse();

        responseItem.setName(technology.getName());
        responseItem.setId(technology.getId());
        responseItem.setLanguageName(technology.getLanguage().getName());


        return responseItem;
    }

}
