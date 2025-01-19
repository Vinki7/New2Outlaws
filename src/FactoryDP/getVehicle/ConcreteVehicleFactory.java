package FactoryDP.getVehicle;


/**
 * This class represents ConcreteVehicleFactory, which is used to create vehicles
 * 
 * @author Šimon Vinkler
 * @version 1.0
 * @since 1.3.2024
 */
public class ConcreteVehicleFactory extends VehicleFactory {
    /**
     * Method used to create vehicle
     * 
     * @param model represents model of vehicle
     * @return VehicleManufacture represents created vehicle
     */
    @Override
    public VehicleManufacture createVehicle(String model) {
        // Implement creation logic for specific types of vehicles
        switch (model.toUpperCase()) {
            case "CHALLENGER":
                return new Vehicle("Dodge", "Challenger", 1970, 425, 664, 5.5, 242, 1455, 7735);
            case "CHARGER":
                return new Vehicle("Dodge", "Charger Daytona", 1969, 425, 664, 6.7, 213, 1477, 7320);
            case "GT40":
                return new Vehicle("Ford", "GT40", 1966, 492, 664, 5.4, 320, 1217, 7735);
            case "MUSTANG":
                return new Vehicle("Ford", "Mustang Mach I", 1969, 335, 597, 5.7, 185, 1636, 4685);
            case "FIREBIRD74":
                return new Vehicle("Pontiac", "Firebird Trans AM", 1974, 314, 529, 7.9, 274, 1956, 3750);
            case "FIREBIRD82":
                return new Vehicle("Pontiac", "Firebird Trans AM II", 1982, 189, 325, 7.6, 200, 1445, 2500);
            // Add more cases for other vehicle models
            default:
                return null;
        }
    }
}
