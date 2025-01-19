package FactoryDP.getParticle;

/**
 * This class represents ConcreteParticleFactory, which is used to create particles
 * 
 *  @author Šimon Vinkler
 *  @version 1.0
 *  @since 1.3.2024
 */
public class ConcreteParticleFactory extends ParticleFactory {
    /**
     * Method used to create particle
     * 
     * @param productType represents type of particle
     * @return ParticleManufacture represents created particle
     */
    @Override
    public ParticleManufacture createParticle(String productType) {
        // Implement creation logic for specific types of vehicles
        switch (productType.toUpperCase()) {
            case "BODY":
                return new Particle(0, 0, -0.5, 4, -250, 1135, "Aerodynamic Bodywork");
            case "ENGINE":
                return new Particle(131, 153, -0.6, 23, 132, 1929, "Empowered Engine");
            case "MCU":
                return new Particle(35, 44, -0.3, 7, 0, 735, "Chipped MCU");
            case "CHASSIS":
                return new Particle(0, 0, -0.6, 6, -173, 1379, "Improved Chassis");
            case "TRANSMISSIONS":
                return new Particle(0, 0, -0.4, 16, 79, 1589, "Improved Transmissions");
            case "WHEELS":
                return new Particle(0, 0, -0.3, 0, -7, 899, "Low Traction Wheels");
            case "AIRINTAKE":
                return new Particle(0, 0, -0.2, 6, 3, 957, "Sports Air Intake");
            default:
                return null;
        }

    }
}
