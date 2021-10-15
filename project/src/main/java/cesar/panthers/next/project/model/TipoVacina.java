package cesar.panthers.next.project.model;

import cesar.panthers.next.project.model.abstracts.AbstractVaccineEntity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(schema = "vaccine_database", name = "vaccine_tipo", uniqueConstraints = { @UniqueConstraint(name = "UNIQUE_NOME", columnNames = "nome") })
public class TipoVacina extends AbstractVaccineEntity {

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "quantidade_doses", nullable = false)
    private Integer quantidadeDoses;

    @Column(name = "intervalo_doses", nullable = false)
    private Integer intervaloDoses;

    @OneToMany(targetEntity = Dose.class, mappedBy = "tipo", orphanRemoval = true, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    private Set<Dose> doses;

    public TipoVacina() {
        this(null);
    }

    public TipoVacina(final String nome) {
        super();
        this.nome = nome;
        this.doses = new LinkedHashSet<>();
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(final String tipo) {
        this.nome = tipo;
    }

    public Integer getQuantidadeDoses() {
        return this.quantidadeDoses;
    }

    public void setQuantidadeDoses(final Integer quantidade_dose) {
        this.quantidadeDoses = quantidade_dose;
    }

    public Integer getIntervaloDoses() {
        return this.intervaloDoses;
    }

    public void setIntervaloDoses(final Integer intervalo_dose) {
        this.intervaloDoses = intervalo_dose;
    }

    public Set<Dose> getDoses() {
        return this.doses;
    }

    public void setDoses(final Set<Dose> doses) {
        this.doses = doses;
    }

    @Override
    public String toString() {
        return String.format("{ %s id=%d, nome='%s', quantidadeDoses=%d, intervaloDoses=%d }",
                super.toString(),
                super.getId(),
                this.getNome(),
                this.getQuantidadeDoses(),
                this.getIntervaloDoses()
        );
    }

}

