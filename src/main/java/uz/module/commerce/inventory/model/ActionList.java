package uz.module.commerce.inventory.model;

import uz.module.commerce.inventory.model.audit.DateAudit;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by User on 22.01.2020.
 */
@Entity
@Table(name = "action_list",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = "id")
        })
public class ActionList extends DateAudit implements Serializable {

    private static final long serialVersionUID = -2798079786988154671L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Warehouse warehouse;

    @Column(name = "quantity", scale = 5)
    private BigDecimal quantity;

    public ActionList(User user, Warehouse warehouse, BigDecimal quantity) {
        this.user = user;
        this.warehouse = warehouse;
        this.quantity = quantity;
    }

    public ActionList() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ActionList{" +
                "id=" + id +
                ", user=" + user +
                ", product=" + warehouse +
                ", quantity=" + quantity +
                '}';
    }
}
