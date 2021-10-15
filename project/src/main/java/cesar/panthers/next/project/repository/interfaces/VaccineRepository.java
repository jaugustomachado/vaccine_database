package cesar.panthers.next.project.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import cesar.panthers.next.project.model.abstracts.AbstractVaccineEntity;

public interface VaccineRepository<T extends AbstractVaccineEntity> extends JpaRepository<T, Long> {
}