package cesar.panthers.next.project.model;

import cesar.panthers.next.project.model.abstracts.AbstractVaccineEntity;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.ArrayList;
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

    public Local() {
        this(null);
    }

    public Local(final String nome) {
        super();
        this.nome_posto=nome;
        this.dose = new ArrayList<>();
    }

    public List<Dose> getDose() {
        return dose;
    }

    public void setDose(List<Dose> dose) {
        this.dose = dose;
    }

    public String getNome_posto() {
        return nome_posto;
    }

    public void setNome_posto(String nome_posto) {
        this.nome_posto = nome_posto;
    }

    public String getBairro_vacinacao() {
        return bairro_vacinacao;
    }

    public void setBairro_vacinacao(String bairro_vacinacao) {
        this.bairro_vacinacao = bairro_vacinacao;
    }

    @Override
    public String toString() {
        return "Local{" +
                "dose=" + dose +
                ", nome_posto='" + nome_posto + '\'' +
                ", bairro_vacinacao='" + bairro_vacinacao + '\'' +
                '}';
    }
}
