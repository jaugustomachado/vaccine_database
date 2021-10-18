package cesar.panthers.next.project.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.text.SimpleDateFormat;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("E")
public class Enfermeiro extends Pessoa {

    @Column(name = "numero_coren", nullable = false, length = 6)
    private String numeroCoren;

    @Column(name = "estado_coren", nullable = false, length = 2)
    private String estadoCoren;

    @OneToMany(targetEntity = Dose.class, mappedBy = "enfermeiro", orphanRemoval = true, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    private Set<Dose> doses;

    public Enfermeiro() {
        this(null);
    }

    public Enfermeiro(final String nome) {
        super(nome);
        this.doses = new LinkedHashSet<>();
    }

    public String getNumeroCoren() {
        return this.numeroCoren;
    }

    public void setNumeroCoren(final String coren) {
        this.numeroCoren = coren;
    }

    public String getEstadoCoren() {
        return this.estadoCoren;
    }

    public void setEstadoCoren(final String estado_coren) {
        this.estadoCoren = estado_coren;
    }

    public Set<Dose> getDoses() {
        return this.doses;
    }

    public void setDoses(final Set<Dose> dose) {
        this.doses = dose;
    }

    @Override
    public String toString() {
        return String.format("{ %s id=%d, nome='%s', cpf='%s', dataNascimento='%s', bairro='%s', numeroCoren='%s', estadoCoren='%s' }",
                super.toString(),
                super.getId(),
                this.getNome(),
                this.getCpf(),
                new SimpleDateFormat("yyyy-MM-dd").format(this.getDataNascimento()),
                this.getBairro(),
                this.getNumeroCoren(),
                this.getEstadoCoren()
        );
    }

}
