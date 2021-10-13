package cesar.panthers.next.project.model.abstracts;

import cesar.panthers.next.project.model.interfaces.VaccineEntity;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractVaccineEntity implements VaccineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id", nullable=false, updatable=false)
    private Long id;

    protected AbstractVaccineEntity(){
        super();
    }
    @Override
    public Long getId() { return id; }

    @Override
    public void setId(Long id) {this.id = id; }
}
