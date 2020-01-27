package uz.module.commerce.inventory.model;

import uz.module.commerce.inventory.model.audit.DateAudit;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by User on 22.01.2020.
 */
@Entity
@Table(name = "user_types",
                uniqueConstraints = {@UniqueConstraint(columnNames = "id")})
public class UserType extends DateAudit implements Serializable{

    private static final long serialVersionUID = 129318938L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @NotNull
    @Column(name = "user_type")
    private String userType;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_type_privileges",
                joinColumns = {@JoinColumn(referencedColumnName = "id")}
                               , inverseJoinColumns = {@JoinColumn(referencedColumnName = "id")})
    private Set<Privilege> privilege;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_type_id")
    private Set<User> users;

    @Column(name = "description")
    private String description;

    public UserType() {
    }

    public UserType(@NotNull String userType, String description) {
        this.userType = userType;
        this.description = description;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Privilege> getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Set<Privilege> privilege) {
        this.privilege = privilege;
    }

    @Override
    public String toString() {
        return "UserType{" +
                "id=" + id +
                ", userType='" + userType + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
