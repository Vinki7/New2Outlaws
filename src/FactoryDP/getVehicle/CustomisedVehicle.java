package FactoryDP.getVehicle;

import Exceptions.Duplicate;
import FactoryDP.getParticle.ConcreteParticleFactory;
import FactoryDP.getParticle.ParticleManufacture;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
/**
 * Represents vehicle, which is modified by user/player. Only one instance per player is allowed
 *
 * @author Šimon Vinkler
 * @version 1.0
 * @since 1.3.2024
 */
public class CustomisedVehicle extends Vehicle implements VehicleManufacture, Serializable {
    /**
     * Number of particles assigned to the vehicle
     */
    private int particleCount = 0;

    /**
     * List of added particles.
     */
    private ArrayList<ParticleManufacture> particles = new ArrayList<>();// This is the composite of the Composite DP

    /**
     * Constructs new custom vehicle
     *
     * @param newVehicle vehicle provided by Factory design pattern
     */
    public CustomisedVehicle(VehicleManufacture newVehicle){
        super(newVehicle.getBrand(),
                newVehicle.getModel(),
                newVehicle.getProductionYear(),
                newVehicle.getHorsePower(),
                newVehicle.getTorque(),
                newVehicle.getAcceleration(),
                newVehicle.getMaxSpeed(),
                newVehicle.getWeight(),
                newVehicle.getPrice());
    }


    /**
     * Adds particle to the compound
     *
     * @param particle represents particle which will be added to the compound, is extracted from Factory design pattern
     * @throws Duplicate if the vehicle already contains the particle
     */
    public void addParticle(ParticleManufacture particle) throws Duplicate {// Add particle also belongs to the Composite DP
        for (ParticleManufacture result: particles){
            if (result.getParticleName().equalsIgnoreCase(particle.getParticleName())){
                throw new Duplicate();
            }
        }
        /* Particle doesn't appear yet in the car */
        // Affect the vehicle
        this.particles.add(particle);// insert new particle to the Composite
        this.particleCount += 1;
        this.acceleration += particle.getAccelerationAffection();
        this.horsePower += particle.getHorsePowerAffection();
        this.maxSpeed += particle.getMaxSpeedAffection();
        this.weight += particle.getWeightAffection();
        this.torque += particle.getTorqueAffection();
        // Logger
        System.out.println("New " + particle.getParticleName() + " successfully added to the vehicle!");

    }

    /**
     * Removes particle from the compound
     *
     * @param particleName name of the particle
     * @return if the process was successful, the return value is null
     * @throws NoSuchElementException if the requested element doesn't exist in the compound
     */
    public ParticleManufacture removeParticle(String particleName) throws NoSuchElementException {// Remove particle -//-
        ParticleManufacture requestedParticle= new ConcreteParticleFactory().createParticle(particleName);

        for (ParticleManufacture particle : particles){
            if (particle.getParticleName().equalsIgnoreCase(requestedParticle.getParticleName())){
                this.particles.remove(particle);
                this.particleCount -= 1;
                this.acceleration -= particle.getAccelerationAffection();
                this.horsePower -= particle.getHorsePowerAffection();
                this.maxSpeed -= particle.getMaxSpeedAffection();
                this.weight -= particle.getWeightAffection();
                this.torque -= particle.getTorqueAffection();
                // Logger
                System.out.println(particle.getParticleName() + " successfully removed from vehicle!");
                return particle;
            }
        }
        throw new NoSuchElementException();
    }

    /**
     * Provides number of particles assigned to the vehicle
     *
     * @return integer representation
     */
    public int getParticleCount() {
        return particleCount;
    }

    /**
     * Extracts characteristic value from vehicle
     *
     * @return String - value of the specification
     */
    public String getBrand(){
        return this.brand;
    }

    /**
     * Extracts characteristic value from vehicle
     *
     * @return String - value of the specification
     */
    public String getModel(){
        return this.model;
    }

    /**
     * Extracts characteristic value from vehicle
     *
     * @return int - value of the specification
     */
    public int getProductionYear(){
        return  productionYear;
    }

    /**
     * Extracts characteristic value from vehicle
     *
     * @return int - value of the specification
     */
    public int getHorsePower() {
        return horsePower;
    }

    /**
     * Extracts characteristic value from vehicle
     *
     * @return int - value of the specification
     */
    public int getTorque() {
        return torque;
    }

    /**
     * Extracts characteristic value from vehicle
     *
     * @return double - value of the specification
     */
    public double getAcceleration() {
        return acceleration;
    }

    /**
     * Extracts characteristic value from vehicle
     *
     * @return int - value of the specification
     */
    public int getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * Extracts characteristic value from vehicle
     *
     * @return int - value of the specification
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Extracts characteristic value from vehicle
     *
     * @return int - value of the specification
     */
    public int getPrice() {
        return price;
    }

    /**
     * Provides list of particles attached to the vehicle
     *
     * @return list of all particles
     */
    public List<ParticleManufacture> getParticles(){
        return this.particles;
    }

}
