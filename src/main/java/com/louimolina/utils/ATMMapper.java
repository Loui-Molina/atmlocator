package com.louimolina.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.louimolina.model.ATM;
import com.louimolina.model.Address;
import com.louimolina.model.Geolocation;
import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.context.annotation.Property;
import io.micronaut.context.annotation.Requires;
import jakarta.inject.Singleton;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Singleton
@ConfigurationProperties("file-url")
public class ATMMapper {

    private static List<ATM> atms;

    @Property(name = "file-url")
    private static String fileUrl;

    /**
     * Uses Jackson library to parse the ATMs into HashMaps
     * and match the values to an ATMs object to be added to the ATMs list
     *
     * @return the list of parsed ATMs
     */
    private static List<ATM> atmObjectMapper() {

        //Jackson mapper object
        ObjectMapper mapper = new ObjectMapper();
        //The JSON obtained from Dropbox
        List<HashMap<String, Object>> JSONList;
        //The ATMs list to return
        List<ATM> ATMList = new ArrayList<>();

        try {
            //Gets the Json from dropbox
            JSONList = mapper.readValue(new URL("https://www.dropbox.com/s/6fg0k2wxwrheyqk/ATMs?dl=1"), ArrayList.class);
            ATM atm;
            Address address;
            Geolocation geolocation;

            //Iterates though the list of JSON Objects obtained
            for (HashMap<String, Object> atmMap : JSONList) {

                geolocation = new Geolocation();
                address = new Address();
                atm = new ATM();

                HashMap<String, Object> addressMap = (HashMap<String, Object>) atmMap.get("address");
                HashMap<String, String> geolocationMap = (HashMap<String, String>) addressMap.get("geoLocation");

                //Set the data parsed to and ATM object
                geolocation.setLat((geolocationMap.get("lat")));
                geolocation.setLng((geolocationMap.get("lng")));
                address.setStreet(String.valueOf(addressMap.get("street")));
                address.setHousenumber(String.valueOf(addressMap.get("housenumber")));
                address.setPostalcode(String.valueOf(addressMap.get("postalcode")));
                address.setCity(String.valueOf(addressMap.get("city")));
                address.setGeoLocation(geolocation);
                atm.setAddress(address);
                atm.setDistance(Integer.parseInt(String.valueOf(atmMap.get("distance"))));
                atm.setType(String.valueOf(atmMap.get("type")));

                ATMList.add(atm);
            }
        } catch (Exception e) {
            e.printStackTrace();

            //If the was an error mapping the JSON the list will remain empty
            ATMList = null;
        }
        return ATMList;
    }

    /**
     * Caches the list of ATMs so we don't have to
     * download and parse the ATMs every search
     *
     * @return the parsed ATMs list
     */
    public static List<ATM> getATMs() {
        if (atms == null) {
            atms = atmObjectMapper();
        }
        return atms;
    }
}
