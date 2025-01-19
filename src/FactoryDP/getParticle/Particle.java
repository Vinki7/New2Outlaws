package FactoryDP.getParticle;

/**
 * This class represents Particle, which is being used as template to other particles
 * 
 * @author Šimon Vinkler
 * @version 1.0
 * @since 1.3.2024
 */
public class Particle implements ParticleManufacture {
    protected int horsePowerAffection;
    protected int torqueAffection;
    protected double accelerationAffection;
    protected int maxSpeedAffection;
    protected int weightAffection;
    protected int price;
    protected String particleName;

    /**
     * Constructor used to create particle
     * 
     * @param horsePowerAffection represents value of horsepower affection
     * @param torqueAffection represents value of torque affection
     * @param accelerationAffection represents value of acceleration affection
     * @param maxSpeedAffection represents value of max speed affection
     * @param weightAffection represents value of weight affection
     * @param price represents price of particle
     * @param particleName represents name of particle
     */
    public Particle(int horsePowerAffection, int torqueAffection, double accelerationAffection, int maxSpeedAffection, int weightAffection, int price, String particleName){
        this.horsePowerAffection = horsePowerAffection;
        this.torqueAffection = torqueAffection;
        this.accelerationAffection = accelerationAffection;
        this.maxSpeedAffection = maxSpeedAffection;
        this.weightAffection = weightAffection;
        this.price = price;
        this.particleName = particleName;
    }

    /**
     * Method used to get horsepower affection
     *
     * @return int represents value of horsepower affection
     */
    @Override
    public int getHorsePowerAffection(){
        return this.horsePowerAffection;
    }

    /**
     * Method used to get torque affection
     *
     * @return int represents value of torque affection
     */
    @Override
    public int getTorqueAffection(){
        return this.torqueAffection;
    }

    /**
     * Method used to get acceleration affection
     *
     * @return double represents value of acceleration affection
     */
    @Override
    public double getAccelerationAffection(){
        return this.accelerationAffection;
    }

    /**
     * Method used to get max speed affection
     *
     * @return int represents value of max speed affection
     */
    @Override
    public int getMaxSpeedAffection(){
        return this.maxSpeedAffection;
    }

    /**
     * Method used to get weight affection
     *
     * @return int represents value of weight affection
     */
    @Override
    public int getWeightAffection(){
        return this.weightAffection;
    }

    /**
     * Method used to get price
     *
     * @return int represents price of particle
     */
    @Override
    public int getPrice(){
        return this.price;
    }

    /**
     * Method used to get particle name
     *
     * @return String represents name of particle
     */
    @Override
    public String getParticleName(){
        return  this.particleName;
    }
}
