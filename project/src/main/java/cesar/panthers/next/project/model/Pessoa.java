package cesar.panthers.next.project.model;

import cesar.panthers.next.project.model.abstracts.AbstractVaccineEntity;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@Entity
@Table(schema="vaccine_database", name = "vaccine_pessoa", uniqueConstraints = {@UniqueConstraint(name = "uk_cpf", columnNames = "cpf")})
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa extends AbstractVaccineEntity {


    @OneToMany(targetEntity = Dose.class, mappedBy = "pessoa", orphanRemoval = true, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Dose> dose;

    @Column(name = "cpf", nullable = false, length = 11)
    private String cpf;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "data_nascimento", nullable = false)
    private Date data_nascimento;

    @Column(name = "bairro", nullable = false, length = 100)
    private String bairro;

    public Pessoa() {
        this(null);
    }

    public Pessoa(final String nome) {
        super();
        this.nome=nome;
        this.dose = new ArrayList<>();
    }

    public List<Dose> getDose() {
        return dose;
    }

    public void setDose(List<Dose> dose) {
        this.dose = dose;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "dose=" + dose +
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", data_nascimento=" + data_nascimento +
                ", bairro='" + bairro + '\'' +
                '}';
    }
}
