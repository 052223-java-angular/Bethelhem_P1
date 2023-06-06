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
    private String id;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="description",nullable = false)
    private String description;

    @Column(name="location",nullable = false)
    private String location;

    @OneToMany(mappedBy = "parks",fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Events> events;

}
