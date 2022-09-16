#ATM Locator
 Simple web service to search in a file downloaded from dropbox for a matching ATM. 
  
 ####ATMLocatorController
 * List<ATM> getATMs(ATMLocatorRequest atmLocatorRequest)       
 
   > Receives an ATMLocatorRequest object with the JSON input received.  
    Assigns the values from the request to a reference ATM object to be passed to the service to retrieve a list of matching ATMs.  
    returns an arrayList of the ATMs that matched the search criteria
 ***
 ####ATMLocatorRequest
 has the fields to be matched to the ATM JSON following the fields:
 ```
 {
	"address": {
		"street": "",
		"housenumber": "",
		"postalcode": "",
		"city": "",
		"geoLocation": {
			"lat": "",
			"lng": ""
		}
	},
	"distance": 0,
	"type": ""
} 
```
 
 ***
 ####ATM, Address, Geolocation
 Model objects to represent the JSON request
 
 ***
 ####ATMLocatorService
* List<ATM> getMatchingATMs(ATM referenceATM)  
>Receives a reference ATM to match to the ATMs list and returns a list of all matching ATMs 
* boolean matchATMs(ATM referenceATM, ATM atm)  
>returns if the reference ATM is equal to the ATM  being checked
* boolean matchDistance(ATM referenceATM, ATM atm)
> returns true if the field is empty on the reference ATM or if it matches to the ATM being compared, false in case it doesn't match 
* boolean matchType(ATM referenceATM, ATM atm)
> returns true if the field is empty on the reference ATM or if it matches to the ATM being compared, false in case it doesn't match 
* boolean matchlatitude(ATM referenceATM, ATM atm)
> returns true if the field is empty on the reference ATM or if it matches to the ATM being compared, false in case it doesn't match 
* boolean matchLongitude(ATM referenceATM, ATM atm)
> returns true if the field is empty on the reference ATM or if it matches to the ATM being compared, false in case it doesn't match 
* boolean matchCity(ATM referenceATM, ATM atm)
> returns true if the field is empty on the reference ATM or if it matches to the ATM being compared, false in case it doesn't match 
* boolean matchPostalCode(ATM referenceATM, ATM atm)
> returns true if the field is empty on the reference ATM or if it matches to the ATM being compared, false in case it doesn't match 
* boolean matchHouseNumber(ATM referenceATM, ATM atm)
> returns true if the field is empty on the reference ATM or if it matches to the ATM being compared, false in case it doesn't match 
* boolean matchStreet(ATM referenceATM, ATM atm)
> returns true if the field is empty on the reference ATM or if it matches to the ATM being compared, false in case it doesn't match 
 ***
 ####ATMMapper
 * static List<ATM> getATMs()
 > Calls the object mapper to retrieve the list of ATMs if there wasn't a cached instance
 * static List<ATM> atmObjectMapper()
 > Retrieves a list of ATMs from Dropbox in JSON formatting then maps it to a list of ATMs and returns it 

 
 