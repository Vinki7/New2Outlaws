package game;

import FactoryDP.getParticle.ConcreteParticleFactory;
import FactoryDP.getVehicle.ConcreteVehicleFactory;
import FactoryDP.getVehicle.CustomisedVehicle;
import FactoryDP.getParticle.ParticleManufacture;
import game.StrategyDP.Difficulty;

import java.io.Serializable;
import java.util.*;

/**
 *  ManagerOfNPC handles the creation of the NPC on the separate thread, which improves performance and independence of the process.
 *
 *  @author Šimon Vinkler
 *  @version 1.0
 *  @since 1.3.2024
 */
public class ManagerOfNPC implements Runnable, Serializable {

    /**
     * This field represents list of generated non-person characters and holds necessary data
     */
    private ArrayList<EnemyAI> listOfNPC = new ArrayList<>();// serialisation should be implemented here

    /**
     * This field contains dataset of usernames, which are being given to the non-person characters during generation
     */
    private List<String> usernames = Arrays.asList(
            "SkyPilot", "WhisperWind", "LunarFlame", "EchoRider", "WildHeart",
            "ShadowWalker", "MysticSinger", "TigerEye", "DragonKnight", "StarSeeker",
            "SoulDancer", "AquaFrost", "EmberCrafter", "VortexRunner", "BlazeWarden",
            "FrostBloom", "StormChaser", "TwilightHunter", "PhoenixRider", "MoonShade",
            "SunsetStrider", "DreamWeaver", "CrimsonTide", "MistWeaver", "SablePhoenix",
            "SpiritDrifter", "SilentWhisper", "EternalFlame", "ShadeSeeker", "CelestialWanderer"
    );

    /**
     * Contains data of newly generated NPC
     */
    private EnemyAI newNPC;

    /**
     * Contains game mode chosen by user
     */
    private Difficulty gameMode;

    /**
     * Represents list of vehicle names extracted from concrete classes
     */
    private ArrayList<String> vehicleNames;

    /**
     * Represents list of particle names extracted from concrete classes
     */
    private ArrayList<String> particleNames;

    private Random random = new Random();

    /**
     * This method is responsible for the generation of the NPC. It iterates through the list of usernames and assigns them to the NPC.
     * It also sets the game mode, vehicle names, and particle names. It generates the vehicle and particles for the NPC.
     */
    @Override
    public void run(){
        int serialNumberNPC = 0; // a.k.a. index in usernames:List<string>

        for (String newUsername:usernames){
            this.newNPC = new EnemyAI();
            this.newNPC.setSerialNumber(serialNumberNPC);
            this.newNPC.setGameMode(gameMode.getDifficulty());
            this.newNPC.setUsername(newUsername);
            setVehicleNames();
            setParticleNames();
            generateVehicle();
            generateParticles();
            serialNumberNPC++;
            listOfNPC.add(this.newNPC);
        }

    }

    /**
     * Constructor of the ManagerOfNPC class. It sets the game mode and runs the generation of the NPC.
     * 
     * @param gameMode
     */
    public ManagerOfNPC(Difficulty gameMode){
        setGameMode(gameMode);
        run();
    }
    /**
     * This method is responsible for the voting of the NPC. It iterates through the list of NPC and votes for the vehicle.
     * 
     * @param votingStatistic
     */
    public void voteAll(HashMap<String, UserRecognition> votingStatistic){
        for (EnemyAI enemy: listOfNPC){
            enemy.voteForVehicle(votingStatistic);
        }
    }

    /**
     * This method sets the vehicle names which are used for the generation of the NPC.
     */
    public void setVehicleNames(){
        this.vehicleNames = new ArrayList<>();
        vehicleNames.add("CHALLENGER");
        vehicleNames.add("CHARGER");
        vehicleNames.add("GT40");
        vehicleNames.add("MUSTANG");
        vehicleNames.add("FIREBIRD74");
        vehicleNames.add("FIREBIRD82");
        // Refactoring the Factory design pattern would be good also for easier implementation of new models, features
        // The structure/enum would be good start
    }

    /**
     * This method sets the particle names which are used for the generation of the NPC.
     */
    public void setParticleNames(){
        particleNames = new ArrayList<>();
        particleNames.add("BODY");
        particleNames.add("ENGINE");
        particleNames.add("MCU");
        particleNames.add("CHASSIS");
        particleNames.add("TRANSMISSIONS");
        particleNames.add("WHEELS");
        particleNames.add("AIRINTAKE");
        // Refactoring the Factory design pattern would be good also for easier implementation of new models, features
        // The structure/enum would be good start
    }

    /**
     * This method sets the game mode chosen by user which is used for the generation of the NPC.
     * 
     * @param gameMode
     */
    public void setGameMode(Difficulty gameMode){
        this.gameMode = gameMode;
    }

    /**
     * This method generates the vehicle for the NPC. It shuffles the list of vehicle names to randomize the order.
     */
    public void generateVehicle(){
        // Shuffle the list to randomize the order
        Collections.shuffle(vehicleNames, random);
        this.newNPC.setCustomisableVehicle(new CustomisedVehicle(new ConcreteVehicleFactory().createVehicle(vehicleNames.getFirst())));
    }

    /**
     * This method generates the particles for the NPC. It shuffles the list of particle names to randomize the order.
     */
    public void generateParticles(){
        Collections.shuffle(particleNames, random);
        for (String particle:particleNames){
            ParticleManufacture potentialParticle = new ConcreteParticleFactory().createParticle(particle);
            int result = this.newNPC.getBudget() - potentialParticle.getPrice();
            if (result > 0){
                try{
                    this.newNPC.getVehicle().addParticle(potentialParticle);
                    this.newNPC.updateBudget(result);
                }catch (Exception e){
                    System.out.println("Error during enemy generation: " + e.getMessage());
                }
            }
        }

    }

    /**
     * This method provides access to the list of generated enemies (to the composite)
     * 
     * @return list of generated enemies
     */
    public ArrayList<EnemyAI> getEnemies(){
        return this.listOfNPC;
    }
}
