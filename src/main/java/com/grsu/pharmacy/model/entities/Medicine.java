package com.grsu.pharmacy.model.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private boolean permissionNeeded;

    @OneToMany(mappedBy = "medicine")
    private List<Prescription> prescriptionList;

    @ManyToMany(mappedBy = "medicines")
    private List<Order> orders;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isPermissionNeeded() {
        return permissionNeeded;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPermissionNeeded(boolean permissionNeeded) {
        this.permissionNeeded = permissionNeeded;
    }

    public List<Prescription> getPrescriptionList() {
        return prescriptionList;
    }

    public void setPrescriptionList(List<Prescription> prescriptionList) {
        this.prescriptionList = prescriptionList;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Medicine() {
    }

    public Medicine(int id, String title, boolean permissionNeeded) {
        this.id = id;
        this.title = title;
        this.permissionNeeded = permissionNeeded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicine medicine = (Medicine) o;
        return id == medicine.id &&
                permissionNeeded == medicine.permissionNeeded &&
                Objects.equals(title, medicine.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, permissionNeeded);
    }
}
