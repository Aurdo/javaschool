package javaschool.java.java_database_classes;

import javax.persistence.*;
/**
 * Created by MSI on 02.02.14.
 */
@Entity
@Table(name= "tags")
public class Tag
{

    private Product product;
    private String tag;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Column(name= "name", length=100)
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
