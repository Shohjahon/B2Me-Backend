package uz.module.commerce.inventory.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by User on 22.01.2020.
 */
@Entity
@Table(name = "product_type",
        uniqueConstraints = {@UniqueConstraint(columnNames = "id")})
public class ProductType implements Serializable{

    private static final long serialVersionUID = 129343438L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @NotNull
    @Column(name = "product_type")
    private String productType;


    @Column(name = "description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_type_id")
    private Set<Product> products;

    public ProductType() {
    }

    public ProductType(@NotNull String productType, String description) {
        this.productType = productType;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
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
        return "ProductType{" +
                "id=" + id +
                ", productType='" + productType + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
