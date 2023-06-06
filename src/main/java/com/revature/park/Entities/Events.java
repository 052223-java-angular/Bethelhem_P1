package com.revature.park.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="events")
public class Events {
    @Id
    private String id;
    @Column(name="name",nullable = false)
    private String name;
    @Column(name="capacity",nullable = false)
    private int capacity;
    @Column(name="description",nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name="park_id")
    @JsonBackReference
    private Parks parks;

    @OneToMany(mappedBy = "events",fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Booking> bookings;

}
