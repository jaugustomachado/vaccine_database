package cesar.panthers.next.project.repository;

import cesar.panthers.next.project.model.Dose;
import cesar.panthers.next.project.repository.interfaces.VaccineRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface DoseRepository extends VaccineRepository<Dose> {
    Set<Dose> findById(final Integer ordem);
    Set<Dose> findAllAsc(final Integer ordem);

}
