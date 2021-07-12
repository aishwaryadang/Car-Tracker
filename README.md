# Car-Tracker
An application that takes in car data and readings and provides REST endpoints for multiple operations.


ENDPOINTS:
Load vehicle details, Passing an Array of Vehicles:

PUT     http://localhost:8080/spring-rest/api/vehicles

---If the vehicle with same VIN is already present, update the record in db.
        
Readings Ingested through following endpoint:

POST    http://localhost:8080/spring-rest/api/readings


Following Alerts are enabled:

    Rule: engineRpm > readlineRpm, Priority: HIGH
    
    Rule: fuelVolume < 10% of maxFuelVolume, Priority: MEDIUM
    
    Rule: tire pressure of any tire < 32psi || > 36psi , Priority: LOW
    
    Rule: engineCoolantLow = true || checkEngineLightOn = true, Priority: LOW
    
GET      http://localhost:8080/spring-rest/api/vehicles

            - Fetch details of all the vehicles like VIN, make, model, year etc.
            
GET      http://localhost:8080/spring-rest/api/vehicles/sortedByVin

            - Fetch HIGH alerts within last 2 hours for all the vehicles and ability to sort list of vehicles based on it.
            
GET      http://localhost:8080/spring-rest/api/vehicles/sortedByVin/{vin}

            - Ability to list a vehicle's all historical alerts.
    
STILL WORKING:
Ability to list vehicle's geolocation within last 30minutes on a map.
