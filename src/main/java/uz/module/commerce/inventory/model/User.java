package uz.module.commerce.inventory.model;

import org.hibernate.validator.constraints.Length;
import uz.module.commerce.inventory.model.audit.DateAudit;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by User on 22.01.2020.
 */
@Entity
@Table(name = "users",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = "id"),
        @UniqueConstraint(columnNames = {"username", "phone_number"})
        })
public class User extends DateAudit implements Serializable{

    private static final long serialVersionUID = -1798079786988154671L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @ManyToOne
    private UserType userType;

    @Column(name = "phone_number", unique = true)
    private String phoneNumber;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "address")
    private String address;

    @Length(min = 6)
    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Set<Warehouse> warehouses;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Set<ActionList> actionLists;

    public User(String fullName, UserType userType, String phoneNumber,
                String username, String address, @Length(min = 6) String password) {
        this.fullName = fullName;
        this.userType = userType;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.address = address;
        this.password = password;
    }

    public User() {
    }

    public Set<ActionList> getActionLists() {
        return actionLists;
    }

    public void setActionLists(Set<ActionList> actionLists) {
        this.actionLists = actionLists;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Warehouse> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(Set<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", userType=" + userType +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", warehouses=" + warehouses +
                '}';
    }
}
