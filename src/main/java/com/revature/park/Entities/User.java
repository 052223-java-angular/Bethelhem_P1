package com.revature.park.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

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

    @Column(name="email",nullable = false)
    private String email;

    @OneToMany(mappedBy = "users",fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Booking> bookings;
}
