package uz.module.commerce.inventory.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by User on 22.01.2020.
 */
@Entity
@Table(name = "measurement_unit",
        uniqueConstraints = {@UniqueConstraint(columnNames = "id")})
public class MeasurementUnit implements Serializable{

    private static final long serialVersionUID = 1293434310L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "unit_name", nullable = false)
    private String unitName;

    @Column(name = "is_active")
    private boolean active;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "measurement_unit_id")
    private Set<Product> products;

    @Column(name = "description")
    private String description;

    public MeasurementUnit() {
    }

    public MeasurementUnit(String unitName, boolean active, String description) {
        this.unitName = unitName;
        this.active = active;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "MeasurementUnit{" +
                "id=" + id +
                ", unitName='" + unitName + '\'' +
                ", active=" + active +
                ", description='" + description + '\'' +
                '}';
    }
}
