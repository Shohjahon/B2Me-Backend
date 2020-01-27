package uz.module.commerce.inventory.model;

import uz.module.commerce.inventory.model.audit.DateAudit;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by User on 22.01.2020.
 */
@Entity
@Table(name = "warehouse",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = "id"),
            @UniqueConstraint(columnNames = "barcode")
})
public class Warehouse extends DateAudit implements Serializable{

    private static final long serialVersionUID = -1798079786993154671L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @ManyToOne
    private Product product;

    @Column(name = "barcode", unique = true, nullable = false)
    private String barcode;

    @Column(name = "price_per_quantity", nullable = false, scale = 5)
    private BigDecimal price;

    @Column(name = "current_quantity", scale = 5)
    private BigDecimal currentQuantity;

    @Column(name = "total_quantity", scale = 5)
    private BigDecimal totalQuantity;

    @Column(name = "is_active")
    private boolean active;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "warehouse_id")
    private Set<ActionList> actionLists;

    @ManyToOne
    private User user;

    public Warehouse(Product product, String barcode, BigDecimal price,
                     BigDecimal currentQuantity, BigDecimal totalQuantity, boolean active, User user) {
        this.product = product;
        this.barcode = barcode;
        this.price = price;
        this.currentQuantity = currentQuantity;
        this.totalQuantity = totalQuantity;
        this.active = active;
        this.user = user;
    }

    public Warehouse() {
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

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(BigDecimal currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    public BigDecimal getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(BigDecimal totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<ActionList> getActionLists() {
        return actionLists;
    }

    public void setActionLists(Set<ActionList> actionLists) {
        this.actionLists = actionLists;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", product=" + product +
                ", barcode='" + barcode + '\'' +
                ", price=" + price +
                ", currentQuantity=" + currentQuantity +
                ", totalQuantity=" + totalQuantity +
                ", active=" + active +
                ", user=" + user +
                '}';
    }
}
