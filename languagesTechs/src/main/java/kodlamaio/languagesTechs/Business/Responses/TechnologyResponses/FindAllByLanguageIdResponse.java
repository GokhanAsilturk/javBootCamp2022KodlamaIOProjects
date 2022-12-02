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
public class FindAllByLanguageIdResponse {
    List<Technology> technologies;
    private String languageName;
}
