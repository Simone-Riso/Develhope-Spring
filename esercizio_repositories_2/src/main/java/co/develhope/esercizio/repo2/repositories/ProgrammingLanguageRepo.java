package co.develhope.esercizio.repo2.repositories;

import co.develhope.esercizio.repo2.entities.ProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.Description;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
        path = "repo-prog-languages",
        collectionResourceDescription = @Description("This is a beautiful description"))
public interface ProgrammingLanguageRepo extends JpaRepository<ProgrammingLanguage, Long> {

}
