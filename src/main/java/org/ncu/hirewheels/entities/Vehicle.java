package org.ncu.hirewheels.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vehicle")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id", nullable = false, precision = 10)
    private Long vehicleId;

    @Column(name = "vehicle_model", nullable = false, length = 50)
    private String vehicleModel;

    @Column(name = "vehicle_number", nullable = false, length = 10)
    private String vehicleNumber;

    @ManyToOne
    @JoinColumn(name = "vehicle_subcategory_id", nullable = false)
    private Vehicle_Subcategory vehicleSubcategory;

    @Column(name = "color", nullable = false, length = 50)
    private String color;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @ManyToOne
    @JoinColumn(name = "fuel_type_id", nullable = false)
    private Fuel_Type fuelType;

    @Column(name = "availability_status", nullable = false)
    private int availabilityStatus;

    @Column(name = "vehicle_image_url", nullable = false, length = 500)
    private String vehicleImageUrl;

    // Constructors, getters, and setters

    // toString() method

    // Other methods or attributes as needed
}