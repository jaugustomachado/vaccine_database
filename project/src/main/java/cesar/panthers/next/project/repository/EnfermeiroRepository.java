package cesar.panthers.next.project.repository;

import cesar.panthers.next.project.model.Enfermeiro;
import cesar.panthers.next.project.repository.interfaces.VaccineRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnfermeiroRepository extends VaccineRepository<Enfermeiro> {

}
