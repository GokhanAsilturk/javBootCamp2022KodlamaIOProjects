package kodlamaio.languagesTechs.DataAccess.Abstracts;

import kodlamaio.languagesTechs.Business.Responses.TechnologyResponses.FindAllByLanguageIdResponse;
import kodlamaio.languagesTechs.Entities.Concretes.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechnologiesRepository extends JpaRepository<Technology,Integer> {


    List<Technology> findAllByLanguage_Id(int id);

}
