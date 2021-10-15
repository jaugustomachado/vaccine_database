package cesar.panthers.next.project.repository.interfaces;

import cesar.panthers.next.project.model.abstracts.AbstractVaccineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccineRepository<T extends AbstractVaccineEntity> extends JpaRepository<T, Long> {

}
