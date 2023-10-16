package org.ncu.hirewheels.entities;

import lombok.*;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicle_subcategory")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle_Subcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_subcategory_id", nullable = false, precision = 10)
    private Long vehicleSubcategoryId;

    @Column(name = "vehicle_subcategory_name", nullable = false, length = 50, unique = true)
    private String vehicleSubcategoryName;

    @Column(name = "price_per_day", nullable = false)
    private Double pricePerDay;

    @ManyToOne
    @JoinColumn(name = "vehicle_category_id", nullable = false)
    private Vehicle_Category vehicleCategory;

    @OneToMany(mappedBy = "vehicleSubcategory")
    private List<Vehicle> vehicles;

    // Constructors, getters, and setters

    // toString() method

    // Other methods or attributes as needed
}
