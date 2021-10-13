package cesar.panthers.next.project.model;

import cesar.panthers.next.project.model.abstracts.AbstractVaccineEntity;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema="vaccine_database", name = "vaccine_dose")
public class Dose extends AbstractVaccineEntity {

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id", nullable = false)
    private Pessoa pessoa;

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinColumn(name = "id_enfermeiro", referencedColumnName = "id", nullable = false)
    private Enfermeiro enfermeiro;

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinColumn(name = "id_local_vacina", referencedColumnName = "id", nullable = false)
    private Local local;

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinColumn(name = "id_tipo_vacina", referencedColumnName = "id", nullable = false)
    private TipoVacina tipo;

    @Column(name = "data_vacinacao", nullable = false)
    private Date data_vacinacao;

    @Column(name = "numero", nullable = false, length = 1)
    private int numero;
}
