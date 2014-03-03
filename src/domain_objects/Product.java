package domain_objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Currency;
import java.util.HashSet;

/**
 * Created by Alex on 3/2/14.
 */

@Entity
@Table(name = "products")
public class Product extends IdentifiableEntity {
    private String name;
    private Currency price;
    private String description;
    private HashSet<Category> categories;
    private HashSet<Tag> tags;

    @Column(name = "name", length = 80, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "price", length = 100, nullable = false)
    public Currency getPrice() {
        return price;
    }

    public void setPrice(Currency price) {
        this.price = price;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToMany(mappedBy = "products")
    public HashSet<Category> getCategories() {
        return categories;
    }

    public void setCategories(HashSet<Category> categories) {
        this.categories = categories;
    }

    @ManyToMany(mappedBy = "products")
    public HashSet<Tag> getTags() {
        return tags;
    }

    public void setTags(HashSet<Tag> tags) {
        this.tags = tags;
    }
}