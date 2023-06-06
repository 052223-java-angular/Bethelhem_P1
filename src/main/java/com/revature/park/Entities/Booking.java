package com.revature.park.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="booking")
public class Booking {
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonBackReference
    private User users;

    @ManyToOne
    @JoinColumn(name="event_id")
    @JsonBackReference
    private Events events;

    @Column(name="attendees_count",nullable = false)
    private int attendees;

    @Column(name="booking_date",nullable = false)
    private Date bookingDate;

    @Column(name="payment_status",nullable = false)
    private boolean paymentStatus;

}
