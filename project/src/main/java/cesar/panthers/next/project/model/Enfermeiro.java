package cesar.panthers.next.project.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema="vaccine_database", name = "vaccine_enfermeiro")
public class Enfermeiro extends Pessoa{

    @OneToMany(targetEntity = Dose.class, mappedBy = "enfermeiro", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Dose> dose;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "id_pessoa_enfermeiro")
    private Pessoa pessoa;

    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "coren", nullable = false, length = 6)
    private String coren;

    @Column(name = "estado_coren", nullable = false, length = 2)
    private String estado_coren;



}
