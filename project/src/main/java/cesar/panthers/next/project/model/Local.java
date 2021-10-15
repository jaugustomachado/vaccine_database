package cesar.panthers.next.project.model;

import cesar.panthers.next.project.model.abstracts.AbstractVaccineEntity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(schema = "vaccine_database", name = "vaccine_local")
public class Local extends AbstractVaccineEntity {

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "bairro", nullable = false, length = 100)
    private String bairro;

    @OneToMany(targetEntity = Dose.class, mappedBy = "local", orphanRemoval = true, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    private Set<Dose> doses;

    public Local() {
        this(null);
    }

    public Local(final String nome) {
        super();
        this.nome = nome;
        this.doses = new LinkedHashSet<>();
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setBairro(final String bairro) {
        this.bairro = bairro;
    }

    public Set<Dose> getDoses() {
        return this.doses;
    }

    public void setDoses(final Set<Dose> doses) {
        this.doses = doses;
    }

    @Override
    public String toString() {
        return String.format("{ %s id=%d, nome='%s', bairro='%s' }",
                super.toString(),
                super.getId(),
                this.getNome(),
                this.getBairro()
        );
    }

}
