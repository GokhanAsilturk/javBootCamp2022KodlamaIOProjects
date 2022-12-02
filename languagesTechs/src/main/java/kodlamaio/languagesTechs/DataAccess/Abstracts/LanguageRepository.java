package kodlamaio.languagesTechs.DataAccess.Abstracts;

import kodlamaio.languagesTechs.Entities.Concretes.Language;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.function.Function;

@Repository
public interface LanguageRepository extends JpaRepository<Language,Integer> {

    Language findByName(String name);

}
