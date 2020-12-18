package com.grsu.pharmacy.model.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "OrdersMedicines",
            joinColumns = {@JoinColumn(name = "orderID")},
            inverseJoinColumns = {@JoinColumn(name = "medicineID")}
    )
    private List<Medicine> medicines;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clientID")
    private User client;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Order() {
    }

    public Order(int id, List<Medicine> medicines, User client) {
        this.id = id;
        this.medicines = medicines;
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id &&
                Objects.equals(new ArrayList(medicines), new ArrayList(order.medicines));
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, medicines);
    }
}
