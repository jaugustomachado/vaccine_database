package cesar.panthers.next.project.model.abstracts;

import cesar.panthers.next.project.model.interfaces.VaccineEntity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

@MappedSuperclass
public abstract class AbstractVaccineEntity implements VaccineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    protected AbstractVaccineEntity() {
        this(0L);
    }

    protected AbstractVaccineEntity(final Long id) {
        super();
        this.id = id;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(final Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(final Object object) {
        boolean result = (null != object);

        result = result && this.getClass().equals(object.getClass()) && Objects.equals(this.getId(), ((AbstractVaccineEntity) object).getId());
        result = result || (this == object);

        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }

}
