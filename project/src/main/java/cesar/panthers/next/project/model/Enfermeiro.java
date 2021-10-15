package cesar.panthers.next.project.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema="vaccine_database", name = "vaccine_enfermeiro")
@PrimaryKeyJoinColumn(name = "id")
public class Enfermeiro extends Pessoa{

    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @OneToMany(targetEntity = Dose.class, mappedBy = "enfermeiro", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Dose> dose;

    @Column(name = "coren", nullable = false, length = 6)
    private String coren;

    @Column(name = "estado_coren", nullable = false, length = 2)
    private String estado_coren;

    public Enfermeiro() {
        this(null);
    }

    public Enfermeiro(final String nome) {
        super(nome);
        this.dose = new ArrayList<>();
    }

    public List<Dose> getDose() {
        return dose;
    }

    public void setDose(List<Dose> dose) {
        this.dose = dose;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getCoren() {
        return coren;
    }

    public void setCoren(String coren) {
        this.coren = coren;
    }

    public String getEstado_coren() {
        return estado_coren;
    }

    public void setEstado_coren(String estado_coren) {
        this.estado_coren = estado_coren;
    }

    @Override
    public String toString() {
        return "Enfermeiro{" +
                "dose=" + dose +
                ", pessoa=" + super.toString() +
                ", id=" + id +
                ", coren='" + coren + '\'' +
                ", estado_coren='" + estado_coren + '\'' +
                '}';
    }
}
