package com.louimolina.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 *
 */
//Lombok Setters, Getters and constructors methods auto-generation
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ATM  {
    private Address address;
    private int distance;
    private String type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ATM atm = (ATM) o;
        return distance == atm.distance &&
                Objects.equals(address, atm.address) &&
                Objects.equals(type, atm.type);
    }
}