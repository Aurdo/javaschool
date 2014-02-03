package javaschool.java.java_database_classes;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import static javax.persistence.GenerationType.IDENTITY;


/**
 * Created by MSI on 02.02.14.
 */
@Entity
@Table(name= "categories")
public class Category
{

    private Integer id;
    private String name;
    private String description;
    private Set<Product> products = new HashSet<Product>(0);

    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name= "name", length=80)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name= "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories")
    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
