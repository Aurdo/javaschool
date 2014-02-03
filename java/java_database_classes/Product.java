package javaschool.java.java_database_classes;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import static javax.persistence.GenerationType.IDENTITY;


/**
 * Created by MSI on 02.02.14.
 */
@Entity
@Table(name= "products")
public class Product
{

    private Integer id;
    private String name;
    private Float price;
    private String description;
    private Set<Category> categories = new HashSet<Category>(0);
    private Set<Tag> tags = new HashSet<Tag>(0);

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

    @Column(name= "price")
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Column(name= "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable( name = "stock_category",
                joinColumns =
                    {
                        @JoinColumn(name = "product_id", nullable = false)
                    },
                inverseJoinColumns =
                    {
                        @JoinColumn(name = "category_id", nullable = false)
                    })
    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "products")
    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }
}