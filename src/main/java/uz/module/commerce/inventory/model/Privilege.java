package uz.module.commerce.inventory.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by User on 22.01.2020.
 */
@Entity
@Table(name = "privileges",
        uniqueConstraints = {@UniqueConstraint(columnNames = "id")})
public class Privilege implements Serializable{

    private static final long serialVersionUID = 129348938L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @NotNull
    @Column(name = "method")
    private String method;

    @NotNull
    @Column(name = "method_code")
    private String methodCode;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "privilege")
    private Set<UserType> userTypes;

    public Privilege() {
    }

    public Privilege(@NotNull String method, @NotNull String methodCode, String description) {
        this.method = method;
        this.methodCode = methodCode;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getMethodCode() {
        return methodCode;
    }

    public void setMethodCode(String methodCode) {
        this.methodCode = methodCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<UserType> getUserTypes() {
        return userTypes;
    }

    public void setUserTypes(Set<UserType> userTypes) {
        this.userTypes = userTypes;
    }

    @Override
    public String toString() {
        return "Privilege{" +
                "id=" + id +
                ", method='" + method + '\'' +
                ", methodCode='" + methodCode + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
