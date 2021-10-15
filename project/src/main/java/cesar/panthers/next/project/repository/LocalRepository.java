package cesar.panthers.next.project.repository;

import cesar.panthers.next.project.model.Local;
import cesar.panthers.next.project.repository.interfaces.VaccineRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalRepository extends VaccineRepository<Local> {

}
