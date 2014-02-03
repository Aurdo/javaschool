package javaschool.java.java_database_classes;

import javax.persistence.*;
/**
 * Created by MSI on 02.02.14.
 */
@Entity
@Table(name= "categories")
public class Category
{
    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name= "name", length=80)
    private String name;
    @Column(name= "description")
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
