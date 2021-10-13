package cesar.panthers.next.project.model;

import cesar.panthers.next.project.model.abstracts.AbstractVaccineEntity;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema="vaccine_database", name = "vaccine_tipo", uniqueConstraints = {@UniqueConstraint(name = "uk_vaccine_tipo", columnNames = "tipo")})
public class TipoVacina extends AbstractVaccineEntity {

    @OneToMany(targetEntity = Dose.class, mappedBy = "tipo", orphanRemoval = true, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    private List<Dose> dose;

    @Column(name = "tipo", nullable = false, length = 100)
    private String tipo;

    @Column(name = "quantidade_dose", nullable = false, length = 1)
    private int quantidade_dose;

    @Column(name = "intervalo_dose", nullable = false, length = 2)
    private int intervalo_dose;
}

