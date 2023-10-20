package org.ncu.hirewheels.entities;

import jakarta.persistence.*;
import javax.validation.*;
import javax.validation.constraints.Size;

import jakarta.*;

import lombok.Data;

@Data
public class Input {
	
	@Size(min = 6, message = "Password must be at least 6 characters long")
    @Column(name = "password")
    private String password;

    @Column(name = "email",length = 50, unique = true)
    private String email;

    @Column(name = "availability_status", length = 1)
    private Integer availabilityStatus;
}