package cesar.panthers.next.project.model;

import cesar.panthers.next.project.model.abstracts.AbstractVaccineEntity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(schema = "vaccine_database", name = "vaccine_pessoa", uniqueConstraints = { @UniqueConstraint(name = "UNIQUE_CPF", columnNames = "cpf") })
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_pessoa", discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("P")
public class Pessoa extends AbstractVaccineEntity {

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "cpf", nullable = false, length = 11)
    private String cpf;

    @Column(name = "data_nascimento", nullable = false)
    private Date dataNascimento;

    @Column(name = "bairro", nullable = false, length = 100)
    private String bairro;

    @OneToMany(targetEntity = Dose.class, mappedBy = "pessoa", orphanRemoval = true, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private Set<Dose> doses;

    public Pessoa() {
        this(null);
    }

    public Pessoa(final String nome) {
        super();
        this.nome=nome;
        this.doses = new LinkedHashSet<>();
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(final String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(final Date data_nascimento) {
        this.dataNascimento = data_nascimento;
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

    public void setDoses(final Set<Dose> dose) {
        this.doses = dose;
    }

    @Override
    public String toString() {
        return String.format("{ %s id=%d, nome='%s', cpf='%s', dataNascimento='%s', bairro='%s' }",
                super.toString(),
                super.getId(),
                this.getNome(),
                this.getCpf(),
                new SimpleDateFormat("yyyy-MM-dd").format(this.getDataNascimento()),
                this.getBairro()
        );
    }

}
