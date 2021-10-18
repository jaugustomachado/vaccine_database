package cesar.panthers.next.project.repository;

import cesar.panthers.next.project.model.Dose;
import cesar.panthers.next.project.repository.interfaces.VaccineRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoseRepository extends VaccineRepository<Dose> {

}
