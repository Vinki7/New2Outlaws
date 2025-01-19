package FactoryDP.getVehicle;

/**
 * This class represents Vehicle, which is being used as template to other vehicles
 * 
 * @author Šimon Vinkler
 * @version 1.0
 * @since 1.3.2024
 */
public class Vehicle implements VehicleManufacture {
    protected String brand;
    protected String model;
    protected int productionYear;
    protected int horsePower;
    protected int torque;
    protected double acceleration;
    protected int maxSpeed;
    protected int weight;
    protected int price;

    /**
     * Constructor used to create vehicle
     * 
     * @param brand represents brand of vehicle
     * @param model represents model of vehicle
     * @param productionYear represents production year of vehicle
     * @param horsePower represents horsepower of vehicle
     * @param torque represents torque of vehicle
     * @param acceleration represents acceleration of vehicle
     * @param maxSpeed represents max speed of vehicle
     * @param weight represents weight of vehicle
     * @param price represents price of vehicle
     */
    public Vehicle(String brand,
                   String model,
                   int productionYear,
                   int horsePower,
                   int torque,
                   double acceleration,
                   int maxSpeed,
                   int weight,
                   int price){
        this.brand = brand;
        this.model = model;
        this.productionYear = productionYear;
        this.horsePower = horsePower;
        this.torque = torque;
        this.acceleration = acceleration;
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.price = price;
    }

    /**
     * Method used to get brand of Challenger
     *
     * @return String represents brand of Challenger
     */
    public String getBrand(){
        return this.brand;
    }

    /**
     * Method used to get model of Challenger
     *
     * @return String represents model of Challenger
     */
    public String getModel(){
        return this.model;
    }

    /**
     * Method used to get production year of Challenger
     *
     * @return int represents production year of Challenger
     */
    public int getProductionYear(){
        return  productionYear;
    }

    /**
     * Method used to get horsepower of Challenger
     *
     * @return int represents horsepower of Challenger
     */
    public int getHorsePower() {
        return horsePower;
    }

    /**
     * Method used to get torque of Challenger
     *
     * @return int represents torque of Challenger
     */
    public int getTorque() {
        return torque;
    }

    /**
     * Method used to get acceleration of Challenger
     *
     * @return double represents acceleration of Challenger
     */
    public double getAcceleration() {
        return acceleration;
    }

    /**
     * Method used to get max speed of Challenger
     *
     * @return int represents max speed of Challenger
     */
    public int getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * Method used to get weight of Challenger
     *
     * @return int represents weight of Challenger
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Method used to get price of Challenger
     *
     * @return int represents price of Challenger
     */
    public int getPrice() {
        return price;
    }
}
