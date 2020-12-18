package com.grsu.pharmacy.model.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "UserRole")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String role;

    @ManyToMany
    @JoinTable(
            name = "Permission",
            joinColumns = { @JoinColumn(name = "userRoleID")},
            inverseJoinColumns = {@JoinColumn(name = "userID")}
    )
    private List<User> users;

    public int getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
