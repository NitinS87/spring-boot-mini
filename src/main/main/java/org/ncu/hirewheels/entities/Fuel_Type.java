package org.ncu.hirewheels.entities;

import jakarta.persistence.*;

import lombok.Data;

@Entity
@Table(name = "fuel_type")
@Data
public class Fuel_Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fuel_type_id", length = 10)
    private Long fuelTypeId;

    @Column(name = "fuel_type", nullable = false, unique = true, length = 50)
    private String fuelType;
}