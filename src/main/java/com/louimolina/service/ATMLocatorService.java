package com.louimolina.service;

import com.louimolina.model.ATM;
import com.louimolina.utils.ATMMapper;
import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Singleton
public class ATMLocatorService {


    public ATMLocatorService() {
    }

    /**
     * Matches the list of ATMs returned from ATMMapper to the reference ATM received as parameter
     * the returns a list of the matching ATMs
     *
     * @param referenceATM received from the controller to match
     * @return the list of matching atms
     */
    public List<ATM> getMatchingATMs(ATM referenceATM) {

        /*
         *list of ATMs matching the reference ATM received
         *to be populated by contrasting the valid data it contains with
         * the list of all ATMs
         */
        List<ATM> matchingATMs = new ArrayList<>();
        if (referenceATM != null) {
            /*
             * gets the parsed list of all ATMs
             * */
            List<ATM> ATMs = (ATMMapper.getATMs());
            //Iterates through the parsed ATMs
            for (ATM atm : ATMs) {
                //If the ATMs match its added to the list
                if (matchATMs(referenceATM, atm)) {
                    matchingATMs.add(atm);
                }
            }
        }
        return matchingATMs;
    }

    /**
     * Checks every field of the ATMs and returns if they match
     *
     * @param referenceATM received from the controller to match
     * @param atm          to match to the referenceATM
     * @return if the complete ATM matches to the reference ATM
     */
    private boolean matchATMs(ATM referenceATM, ATM atm) {
        return matchStreet(referenceATM, atm) &&
                matchHouseNumber(referenceATM, atm) &&
                matchPostalCode(referenceATM, atm) &&
                matchCity(referenceATM, atm) &&
                matchLatitude(referenceATM, atm) &&
                matchLongitude(referenceATM, atm) &&
                matchDistance(referenceATM, atm) &&
                matchType(referenceATM, atm);
    }

    /**
     * Checks the Distance of the ATMs and  returns if they match
     *
     * @param referenceATM received from the controller to match
     * @param atm          to match to the referenceATM
     * @return if the Distance matches in both ATMs
     */
    private boolean matchDistance(ATM referenceATM, ATM atm) {
        return -1 == referenceATM.getDistance() || atm.getDistance() == (referenceATM.getDistance());
    }

    /**
     * Checks the Type of the ATMs and  returns if they match
     *
     * @param referenceATM received from the controller to match
     * @param atm          to match to the referenceATM
     * @return if the Type matches in both ATMs or if the value of the reference isn't valid
     */
    private boolean matchType(ATM referenceATM, ATM atm) {
        return "".equalsIgnoreCase(referenceATM.getType()) || atm.getType().equalsIgnoreCase(referenceATM.getType());
    }

    /**
     * Checks the Street of the ATMs and  returns if they match
     *
     * @param referenceATM received from the controller to match
     * @param atm          to match to the referenceATM
     * @return if the Street matches in both ATMs or if the value of the reference isn't valid
     */
    private boolean matchStreet(ATM referenceATM, ATM atm) {
        return "".equalsIgnoreCase(Optional.of(referenceATM.getAddress().getStreet()).orElse(""))
                || atm.getAddress().getStreet().equalsIgnoreCase(referenceATM.getAddress().getStreet());
    }

    /**
     * Checks the House Number of the ATMs and  returns if they match
     *
     * @param referenceATM received from the controller to match
     * @param atm          to match to the referenceATM
     * @return if the House Number matches in both ATMs or if the value of the reference isn't valid
     */
    private boolean matchHouseNumber(ATM referenceATM, ATM atm) {
        return "".equalsIgnoreCase(referenceATM.getAddress().getHousenumber()) || atm.getAddress().getHousenumber().equalsIgnoreCase(referenceATM.getAddress().getHousenumber());
    }

    /**
     * Checks the City of the ATMs and  returns if they match
     *
     * @param referenceATM received from the controller to match
     * @param atm          to match to the referenceATM
     * @return if the City matches in both ATMs or if the value of the reference isn't valid
     */
    private boolean matchCity(ATM referenceATM, ATM atm) {
        return "".equalsIgnoreCase(referenceATM.getAddress().getCity()) || atm.getAddress().getCity().equalsIgnoreCase(referenceATM.getAddress().getCity());
    }

    /**
     * Checks the Postal Code of the ATMs and  returns if they match
     *
     * @param referenceATM received from the controller to match
     * @param atm          to match to the referenceATM
     * @return if the Postal Code matches in both ATMs or if the value of the reference isn't valid
     */
    private boolean matchPostalCode(ATM referenceATM, ATM atm) {
        return "".equalsIgnoreCase(referenceATM.getAddress().getPostalcode()) || atm.getAddress().getPostalcode().equalsIgnoreCase(referenceATM.getAddress().getPostalcode());
    }

    /**
     * Checks the Latitude of the ATMs and  returns if they match
     *
     * @param referenceATM received from the controller to match
     * @param atm          to match to the referenceATM
     * @return if the Latitude matches in both ATMs or if the value of the reference isn't valid
     */
    private boolean matchLatitude(ATM referenceATM, ATM atm) {
        return null == referenceATM.getAddress().getGeoLocation() || "".equalsIgnoreCase(referenceATM.getAddress().getGeoLocation().getLat()) || atm.getAddress().getGeoLocation().getLat().equalsIgnoreCase(referenceATM.getAddress().getGeoLocation().getLat());
    }

    /**
     * Checks the Longitude of the ATMs and  returns if they match
     *
     * @param referenceATM received from the controller to match
     * @param atm          to match to the referenceATM
     * @return if the Longitude matches in both ATMs or if the value of the reference isn't valid
     */
    private boolean matchLongitude(ATM referenceATM, ATM atm) {
        return null == referenceATM.getAddress().getGeoLocation() || "".equalsIgnoreCase(referenceATM.getAddress().getGeoLocation().getLat()) || atm.getAddress().getGeoLocation().getLat().equalsIgnoreCase(referenceATM.getAddress().getGeoLocation().getLat());
    }

}
