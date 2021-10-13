package cesar.panthers.next.project.model;

import cesar.panthers.next.project.model.abstracts.AbstractVaccineEntity;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(schema="vaccine_database", name = "vaccine_local")
public class Local extends AbstractVaccineEntity {

    @OneToMany(targetEntity = Dose.class, mappedBy = "local", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Dose> dose;

    @Column(name = "nome_posto", nullable = false, length = 100)
    private String nome_posto;

    @Column(name = "bairro_vacinacao", nullable = false, length = 100)
    private String bairro_vacinacao;

}
