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

    public Dose() {
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Enfermeiro getEnfermeiro() {
        return enfermeiro;
    }

    public void setEnfermeiro(Enfermeiro enfermeiro) {
        this.enfermeiro = enfermeiro;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public TipoVacina getTipo() {
        return tipo;
    }

    public void setTipo(TipoVacina tipo) {
        this.tipo = tipo;
    }

    public Date getData_vacinacao() {
        return data_vacinacao;
    }

    public void setData_vacinacao(Date data_vacinacao) {
        this.data_vacinacao = data_vacinacao;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Dose{" +
                "pessoa=" + pessoa +
                ", enfermeiro=" + enfermeiro +
                ", local=" + local +
                ", tipo=" + tipo +
                ", data_vacinacao=" + data_vacinacao +
                ", numero=" + numero +
                '}';
    }
}
