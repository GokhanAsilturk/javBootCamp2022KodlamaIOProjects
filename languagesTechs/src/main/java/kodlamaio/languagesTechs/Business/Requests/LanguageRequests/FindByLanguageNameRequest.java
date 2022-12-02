package kodlamaio.languagesTechs.Business.Requests.LanguageRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindByLanguageNameRequest {

    private String name;
}
