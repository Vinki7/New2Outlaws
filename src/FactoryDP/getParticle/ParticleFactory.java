package FactoryDP.getParticle;

/**
 * This class represents ParticleFactory, which is used to create particles
 * 
 *  @author Šimon Vinkler
 *  @version 1.0
 *  @since 1.3.2024
 */
public abstract class ParticleFactory {
    /**
     * Method used to create particle
     * 
     * @param productType represents type of particle
     * @return ParticleManufacture represents created particle
     */
    public abstract ParticleManufacture createParticle(String productType);

}
