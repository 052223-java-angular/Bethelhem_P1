package com.revature.park.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name="users")
public class User {
    @Id
    private String id;

    @Column(name="name",nullable = false)
    private String username;

    @Column(name="password",nullable = false)
    private String password;

    @Column(name="email",nullable = true)
    private String email;

    @OneToMany(mappedBy = "users",fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Booking> bookings;

    public User(String username, String password,String email) {
        this.id = UUID.randomUUID().toString();
        this.username = username;
        this.password = password;
        this.email=email;

    }

}
