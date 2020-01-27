package uz.module.commerce.inventory.model;

import uz.module.commerce.inventory.model.audit.DateAudit;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by User on 22.01.2020.
 */
@Entity
@Table(name = "products",
        uniqueConstraints = {@UniqueConstraint(columnNames = "id")})
public class Product extends DateAudit implements Serializable{

    private static final long serialVersionUID = -1798070786993154676L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @ManyToOne
    private MeasurementUnit measurementUnit;

    @ManyToOne
    private ProductType productType;

    @Column(name = "description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Set<ProductAttributes> productAttributes;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Set<Warehouse> warehouses;



    public Product(String productName, MeasurementUnit measurementUnit, ProductType productType, String description) {
        this.productName = productName;
        this.measurementUnit = measurementUnit;
        this.productType = productType;
        this.description = description;
    }

    public Product() {
    }

    public Set<Warehouse> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(Set<Warehouse> warehouses) {
        this.warehouses = warehouses;
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public MeasurementUnit getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(MeasurementUnit measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", measurementUnit=" + measurementUnit +
                ", productType=" + productType +
                ", description='" + description + '\'' +
                '}';
    }
}
