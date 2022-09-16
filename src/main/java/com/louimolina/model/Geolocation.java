package com.louimolina.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *Geolocation object contained in the address
 */
//Lombok Setters, Getters, constructor, Equals and hashCode methods auto-generation
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Geolocation {
    private String lat;
    private String lng;


    @Override
    public String toString() {
        return "Geolocation{" +
                "lat=" + lat +
                ", lng=" + lng +
                '}';
    }


}
