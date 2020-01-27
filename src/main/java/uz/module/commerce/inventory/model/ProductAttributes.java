package uz.module.commerce.inventory.model;

import uz.module.commerce.inventory.model.audit.DateAudit;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by User on 22.01.2020.
 */
@Entity
@Table(name = "product_attributes",
        uniqueConstraints = {@UniqueConstraint(columnNames = "id")})
public class ProductAttributes extends DateAudit implements Serializable{

    private static final long serialVersionUID = -1798070786993154671L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Attribute attribute;

    @Column(name = "attribute_value", nullable = false)
    private String attributeValue;

    public ProductAttributes(Product product, Attribute attribute, String attributeValue) {
        this.product = product;
        this.attribute = attribute;
        this.attributeValue = attributeValue;
    }

    public ProductAttributes() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }

    @Override
    public String toString() {
        return "ProductAttributes{" +
                "id=" + id +
                ", product=" + product +
                ", attribute=" + attribute +
                ", attributeValue='" + attributeValue + '\'' +
                '}';
    }
}
