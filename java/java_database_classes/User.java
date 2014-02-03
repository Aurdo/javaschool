package javaschool.java.java_database_classes;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by MSI on 02.02.14.
 */
@Entity
@Table(name= "users")

public class User
{

    private Integer id;
    private String name;
    private Boolean isAdmin;
    private String Password;

    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name= "name", length=100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name= "is_admin")
    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Column(name= "password", length=128)
    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
