package domain_objects;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Alex on 2/20/14.
 */
@MappedSuperclass
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
abstract class IdentifiableEntity implements BaseDomainObject, Serializable {

    private int id;

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
