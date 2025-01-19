package FactoryDP.getVehicle;

/**
 * Represents form for creating new vehicles - used in Factory design pattern. Also implements Manufacture Interface, which resembles Factories
 *
 * @author Šimon Vinkler
 * @version 1.0
 * @since 1.3.2024
 */
public abstract class VehicleFactory {
    /**
     * Constructor - constructs the new vehicle, used in Factory design pattern
     *
     * @param productType provides information to the Factory which product should be provided in output
     * @return the product chosen by parameter ProductType which is of type VehicleManufacture
     */
    public abstract VehicleManufacture createVehicle(String productType);

}
