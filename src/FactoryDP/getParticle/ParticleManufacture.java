package FactoryDP.getParticle;

/**
 * This interface represents ParticleManufacture, which is used to create particles
 *
 *  @author Šimon Vinkler
 *  @version 1.0
 *  @since 1.3.2024
 */
public interface ParticleManufacture {

    /**
     * Method used to get horsepower affection
     * 
     * @return int represents value of horsepower affection
     */
    int getHorsePowerAffection();

    /**
     * Method used to get torque affection
     * 
     * @return int represents value of torque affection
     */
    int getTorqueAffection();

    /**
     * Method used to get acceleration affection
     * 
     * @return double represents value of acceleration affection
     */
    double getAccelerationAffection();

    /**
     * Method used to get max speed affection
     * 
     * @return int represents value of max speed affection
     */
    int getMaxSpeedAffection();

    /**
     * Method used to get weight affection
     * 
     * @return int represents value of weight affection
     */
    int getWeightAffection();

    /**
     * Method used to get price
     * 
     * @return int represents price of particle
     */
    int getPrice();

    /**
     * Method used to get particle name
     * 
     * @return String represents name of particle
     */
    String getParticleName();
}
