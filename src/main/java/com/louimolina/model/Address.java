package com.louimolina.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * Address contained in the ATM object
 */
//Lombok Setters, Getters and constructors methods auto-generation
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String street;
    private String housenumber;
    private String postalcode;
    private String city;
    private Geolocation geoLocation;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return housenumber == address.housenumber &&
                Objects.equals(street, address.street) &&
                Objects.equals(postalcode, address.postalcode) &&
                Objects.equals(city, address.city) &&
                Objects.equals(geoLocation, address.geoLocation);
    }
}
