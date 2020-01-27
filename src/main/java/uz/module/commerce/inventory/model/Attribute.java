package uz.module.commerce.inventory.model;

import uz.module.commerce.inventory.model.audit.DateAudit;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by User on 22.01.2020.
 */
@Entity
@Table(name = "attributes",
        uniqueConstraints = {@UniqueConstraint(columnNames = "id")})
public class Attribute extends DateAudit implements Serializable{

    private static final long serialVersionUID = -1798070786993154676L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "attribute_name", nullable = false)
    private String attributeName;

    @Column(name = "is_mandatory")
    private boolean mandatory;

    @Column(name = "is_active")
    private boolean active;

    @Column(name = "description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "attribute_id")
    private Set<ProductAttributes> productAttributes;


    public Attribute() {
    }

    public Attribute(String attributeName, boolean mandatory, boolean active, String description) {
        this.attributeName = attributeName;
        this.mandatory = mandatory;
        this.active = active;
        this.description = description;
    }

    public Set<ProductAttributes> getProductAttributes() {
        return productAttributes;
    }

    public void setProductAttributes(Set<ProductAttributes> productAttributes) {
        this.productAttributes = productAttributes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public boolean isMandatory() {
        return mandatory;
    }

    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
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

    @Override
    public String toString() {
        return "Attribute{" +
                "id=" + id +
                ", attributeName='" + attributeName + '\'' +
                ", mandatory=" + mandatory +
                ", active=" + active +
                ", description='" + description + '\'' +
                '}';
    }
}
