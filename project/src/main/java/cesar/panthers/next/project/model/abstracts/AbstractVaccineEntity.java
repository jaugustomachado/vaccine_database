package cesar.panthers.next.project.model.abstracts;

import cesar.panthers.next.project.model.interfaces.VaccineEntity;

import javax.persistence.*;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractVaccineEntity)) return false;
        AbstractVaccineEntity that = (AbstractVaccineEntity) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
