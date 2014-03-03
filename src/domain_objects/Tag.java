package domain_objects;

import javax.persistence.*;
import java.util.HashSet;

/**
 * Created by Alex on 3/3/14.
 */
@Entity
@Table(name = "tags")
public class Tag extends IdentifiableEntity {
    private String tag;
    private HashSet<Product> products;

    @Column(name = "tag", length = 100, nullable = false, unique = true)
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "tag_to_product",
            joinColumns = {@JoinColumn(name = "tag_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "product_id", nullable = false)})
    public HashSet<Product> getProducts() {
        return products;
    }

    public void setProducts(HashSet<Product> products) {
        this.products = products;
    }
}
