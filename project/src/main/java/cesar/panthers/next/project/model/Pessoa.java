package cesar.panthers.next.project.model;

import cesar.panthers.next.project.model.abstracts.AbstractVaccineEntity;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.List;
import java.util.Date;



@Entity
@Table(schema="vaccine_database", name = "vaccine_pessoa", uniqueConstraints = {@UniqueConstraint(name = "uk_cpf", columnNames = "cpf")})
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

}
