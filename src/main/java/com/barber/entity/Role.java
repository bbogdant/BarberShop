package com.barber.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "role")
public class Role {

    public static final String USER = "User";
    public static final String ADMIN = "Admin";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", nullable = false)
    private Integer id;

    @Column(name = "role_name")
    private String roleName;

    @OneToMany(mappedBy = "role")
    private Set<Customer> customers = new LinkedHashSet<>();

    @Override
    public String toString() {
        return roleName;
    }
}