package org.example;

import lombok.Data;

@Data
public abstract class Vehicle {
    private final VehicleType vehicleType;
    private final String licenseNumber;
}
