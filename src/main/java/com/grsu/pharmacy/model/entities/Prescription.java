package com.grsu.pharmacy.model.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "medicineID")
    private Medicine medicine;
    private Date expirationDate;

    @ManyToOne
    @JoinColumn(name = "clientID")
    private User client;

    public int getId() {
        return id;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Prescription() {
    }

    public Prescription(int id, Medicine medicine, Date expirationDate, User client) {
        this.id = id;
        this.medicine = medicine;
        this.expirationDate = expirationDate;
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prescription that = (Prescription) o;
        return id == that.id &&
                medicine.equals(that.medicine) &&
                client.equals(that.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, medicine, expirationDate, client);
    }
}
