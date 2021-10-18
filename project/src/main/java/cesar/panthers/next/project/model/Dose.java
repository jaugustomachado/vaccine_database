package cesar.panthers.next.project.model;

import cesar.panthers.next.project.model.abstracts.AbstractVaccineEntity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(schema = "vaccine_database", name = "vaccine_dose")
public class Dose extends AbstractVaccineEntity {

    @Column(name = "data_vacinacao", nullable = false)
    private Date dataVacinacao;

    @Column(name = "ordem", nullable = false)
    private Integer ordem;

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinColumn(foreignKey = @ForeignKey(name = "FOREIGN_PESSOA"), name = "id_pessoa", referencedColumnName = "id", nullable = false)
    private Pessoa pessoa;

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinColumn(foreignKey = @ForeignKey(name = "FOREIGN_ENFERMEIRO"), name = "id_enfermeiro", referencedColumnName = "id", nullable = false)
    private Enfermeiro enfermeiro;

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinColumn(foreignKey = @ForeignKey(name = "FOREIGN_LOCAL"), name = "id_local_vacina", referencedColumnName = "id", nullable = false)
    private Local local;

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinColumn(foreignKey = @ForeignKey(name = "FOREIGN_TIPO"), name = "id_tipo_vacina", referencedColumnName = "id", nullable = false)
    private TipoVacina tipo;

    public Dose() {
        super();
    }

    public Date getDataVacinacao() {
        return this.dataVacinacao;
    }

    public void setDataVacinacao(final Date dataVacinacao) {
        this.dataVacinacao = dataVacinacao;
    }

    public Integer getOrdem() {
        return this.ordem;
    }

    public void setOrdem(final Integer numero) {
        this.ordem = numero;
    }

    public Pessoa getPessoa() {
        return this.pessoa;
    }

    public void setPessoa(final Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Enfermeiro getEnfermeiro() {
        return this.enfermeiro;
    }

    public void setEnfermeiro(final Enfermeiro enfermeiro) {
        this.enfermeiro = enfermeiro;
    }

    public Local getLocal() {
        return this.local;
    }

    public void setLocal(final Local local) {
        this.local = local;
    }

    public TipoVacina getTipo() {
        return this.tipo;
    }

    public void setTipo(final TipoVacina tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return String.format("{ %s id=%d, dataVacinacao='%s', ordem=%d, pessoa='%s', enfermeiro=%s, local=%s, tipo=%s }",
                super.toString(),
                super.getId(),
                new SimpleDateFormat("yyyy-MM-dd").format(this.getDataVacinacao()),
                this.getOrdem(),
                this.getPessoa(),
                this.getEnfermeiro(),
                this.getLocal(),
                this.getTipo()
        );
    }

}
