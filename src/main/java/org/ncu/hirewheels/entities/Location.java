package org.ncu.hirewheels.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "location")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id", nullable = false, precision = 10)
    private Long locationId;

    @Column(name = "location_name", nullable = false, length = 50)
    private String locationName;

    @Column(name = "address", nullable = false, length = 100)
    private String address;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @Column(name = "pincode", nullable = false, length = 6)
    private String pincode;

    @OneToMany(mappedBy = "location", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Booking> bookings;

    @OneToMany(mappedBy = "location")
    private List<Vehicle> vehicles;


    // Constructors, getters, and setters

    // toString() method

    // Other methods or attributes as needed
}
