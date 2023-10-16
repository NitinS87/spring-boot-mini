package org.ncu.hirewheels.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vehicle_category")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle_Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_category_id", nullable = false, precision = 10)
    private Long vehicleCategoryId;

    @Column(name = "vehicle_category_name", nullable = false, length = 50, unique = true)
    private String vehicleCategoryName;

    // Constructors, getters, and setters

    // toString() method

    // Other methods or attributes as needed
}
