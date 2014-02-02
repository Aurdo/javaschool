package java_database_classes;

/**
 * Created by MSI on 02.02.14.
 */
public class Product {
    private Integer id;
    private String name;
    private Float prise;
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

    public Float getPrise() {
        return prise;
    }

    public void setPrise(Float prise) {
        this.prise = prise;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}