package domain_objects;

import javax.persistence.*;

@Entity
@Table(name = "categories")
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@AttributeOverride(name = "id",column = @Column(name = "id"))
public class Category extends IdentifiableEntity {

    //private int id;
    private String name;
    private String description;

    public Category() {
    }
/*
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }*/

    @Column(name = "name", nullable = false, length = 80, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /*@Transient
    public Class getDomainObjectClass() {
        return Category.class;
    }*/
}
