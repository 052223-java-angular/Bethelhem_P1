package com.revature.park.Entities;

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
@Table(name="park")
public class Parks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name",nullable = false)
    private String name;

    @Lob
    @Column(name="description",columnDefinition = "TEXT",nullable = false)
    private String description;

    @Column(name="postal_code",nullable = false)
    private String postal_code;

    @Column(name="city",nullable = false)
    private String city;

    @Column(name="state",nullable = false)
    private String state;

    @OneToMany(mappedBy = "parks",fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Events> events;

}
