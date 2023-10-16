package org.ncu.hirewheels.entities;


import lombok.*;
import jakarta.persistence.*;


import java.util.Date;

@Entity
@Table(name = "booking")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id", nullable = false, precision = 10)
    private Long bookingId;

    @Column(name = "pickup_date", nullable = false)
    private Date pickupDate;

    @Column(name = "dropoff_date", nullable = false)
    private Date dropoffDate;

    @Column(name = "booking_date", nullable = false)
    private Date bookingDate;

    @Column(name = "amount", nullable = false )
    private Double amount;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    private Location location;
    @ManyToOne
    @JoinColumn(name = "vehicle_id") // This references the foreign key column in the Booking table
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "user_id") // This references the foreign key column in the Booking table
    private User user;

    // Constructors, getters, and setters

    // toString() method

    // Other methods or attributes as needed
}
