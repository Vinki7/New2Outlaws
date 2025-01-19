package FactoryDP.getVehicle;

/**
 * Represents interface, which holds necessary methods for proper functionality of Factory design pattern which constructs the vehicle
 *
 * @author Šimon Vinkler
 * @version 1.0
 * @since 1.3.2024
 */
public interface VehicleManufacture {

    /**
     * Method used to get brand of vehicle
     *
     * @return String represents brand of vehicle
     */
    String getBrand();

    /**
     * Method used to get model of vehicle
     *
     * @return String represents model of vehicle
     */
    String getModel();

    /**
     * Method used to get production year of vehicle
     *
     * @return int represents production year of vehicle
     */
    int getProductionYear();

    /**
     * Method used to get horsepower of vehicle
     *
     * @return int represents horsepower of vehicle
     */
    int getHorsePower();

    /**
     * Method used to get torque of vehicle
     *
     * @return int represents torque of vehicle
     */
    int getTorque();

    /**
     * Method used to get acceleration of vehicle
     *
     * @return double represents acceleration of vehicle
     */
    double getAcceleration();

    /**
     * Method used to get max speed of vehicle
     *
     * @return int represents max speed of vehicle
     */
    int getMaxSpeed();

    /**
     * Method used to get weight of vehicle
     *
     * @return int represents weight of vehicle
     */
    int getWeight();

    /**
     * Method used to get price of vehicle
     *
     * @return int represents price of vehicle
     */
    int getPrice();// take this to the Manufacture:interface
}
