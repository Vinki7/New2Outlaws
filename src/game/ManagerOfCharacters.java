package game;

import Exceptions.IncorrectLoginData;
import Exceptions.IncorrectRegistrationData;
import Exceptions.InsufficientFunds;
import FactoryDP.getParticle.ConcreteParticleFactory;
import FactoryDP.getParticle.ParticleManufacture;
import FactoryDP.getVehicle.ConcreteVehicleFactory;
import FactoryDP.getVehicle.CustomisedVehicle;
import game.ObserverDP.UserStatusObserver;

import java.io.File;
import java.io.FileWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *  ManagerOfCharacters represents Model from MVC design pattern. Handles whole data and logic and communicates with controller (MVC)
 *
 *  @author Šimon Vinkler
 *  @version 1.0
 *  @since 1.3.2024
 */
public class ManagerOfCharacters implements Serializable{

    /**
     * Instance of User class, which represents person voting and actively managing its behavior, independently of
     * simulated characters which act as a living creature - they have predefined behavior
     */
    private User newUser;

    /**
     * userStatusObserver represents part of Observer design pattern
     */
    private final transient UserStatusObserver userStatusObserver;

    /**
     * Handles non-person characters - creation, voting...
     */
    private ManagerOfNPC managerOfNPC;

    /**
     * Handles the voting process
     */
    private final VotingControl votingControl = new VotingControl();

    private File usernames;
    private File passwords;

    /**
     * Constructs whole object and also initializes the Observer
     */
    public ManagerOfCharacters(){
        userStatusObserver = new UserStatusObserver();
    }

    /**
     * {@link ManagerOfNPC} implements {@link Runnable} interface, which causes multi-threading and makes operations run separately
     */
    public void setManagerOfNPC(){
        this.managerOfNPC = new ManagerOfNPC(newUser.getGameMode());
    }

    /**
     * Getter
     *
     * @return {@link UserStatusObserver} which represents Observer design pattern implementation
     */
    public UserStatusObserver getUserStatusObserver(){
        return userStatusObserver;
    }

    /**
     * logIn() handles the log-in stage of the application, manages the user's log-in credentials etc.
     *
     * @return boolean value based on the success state of the process
     */
    public boolean logIn(String inputUsername, String inputPassword) throws IncorrectLoginData {// Refactored
        try{
            if (usernames == null){
                //usernames = new File("C:\\Users\\User\\eclipse-workspace\\Application_OOP\\oop-2024-stv-17-b-pechac-Vinki7\\App_OOP\\database\\userNames");
                //passwords = new File("C:\\Users\\User\\eclipse-workspace\\Application_OOP\\oop-2024-stv-17-b-pechac-Vinki7\\App_OOP\\database\\passwords");
                usernames = new File("..\\App_OOP\\database\\userNames");
                passwords = new File("..\\App_OOP\\database\\passwords");

            }
        }catch (Exception e){
            System.out.println("An error appeared during database accessing.");
            return false;
        }


        boolean usernameFound = false;
        boolean passwordFound = false;

        try(Scanner scanner = new Scanner(usernames)){
            while(scanner.hasNextLine()){
                if (scanner.nextLine().equals(inputUsername)){
                    usernameFound = true;
                    break;
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        if (!usernameFound){
            System.out.println("--login failed");
            throw new IncorrectLoginData("Wrong username!");
        }

        try(Scanner scanner = new Scanner(passwords)){
            while (scanner.hasNextLine()){
                if (scanner.nextLine().equals(inputPassword)){
                    passwordFound = true;
                    break;
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        if (!passwordFound){
            System.out.println("--login failed");
            throw new IncorrectLoginData("Wrong password!");
        }
        this.setNewUser(inputUsername, inputPassword);
        System.out.println("--login successful --username: " + this.newUser.getUsername());
        return true;
    }


    /**
     * Handles logout process
     *
     * @return boolean value based on the success state of the process
     */
    public boolean logOut(){
        // Store the data to the list of players - serialisation will be applied later
        //listOfPlayers.add(actualUser);
        // Create space for new user to log in
        this.newUser = null;
        this.managerOfNPC = null;
        return true;
    }

    /**
     * Foundation for future implementation of serialisation
     *
     * @return boolean value based on the success state of the process
     */
    public boolean save(){
        return this.newUser.serialisation();
    }

    /**
     * Foundation for future implementation of serialisation
     *
     * @return boolean value based on the success state of the process
     */
    public boolean load(){
        User loadedUser = this.newUser.deSerialisation();
        if (loadedUser != null){
            this.newUser.setUsername(loadedUser.getUsername());
            this.newUser.setFavourite(loadedUser.getFavourite());
            this.newUser.setCustomisableVehicle(loadedUser.getVehicle());
            return true;
        }
        return false;
    }

    /**
     * Handles the registration process of user, guides user through the entrance portal of the application
     * If user already has an account, then is being redirected to the log-in page/stage.
     *
     * @param inputUsername represents username provided during registration
     * @param inputPassword represents password provided during registration
     * @param repeatedPassword represents repeated password provided during registration for correctness of the credentials
     * @return boolean value based on the success state of the process
     */
    public boolean register(String inputUsername, String inputPassword, String repeatedPassword) throws IncorrectRegistrationData {
        try {
            if (usernames == null) {
                usernames = new File("..\\App_OOP\\database\\userNames");
                passwords = new File("..\\App_OOP\\database\\passwords");
            }
        } catch (Exception e) {
            System.out.println("An error appeared during database accessing.");
            return false;
        }

        boolean usernameFound = false;
        boolean passwordMatch = false;

        try (Scanner scanner = new Scanner(usernames)) {
            while (scanner.hasNextLine()) {
                if (scanner.nextLine().equals(inputUsername)) {
                    usernameFound = true;
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (usernameFound) {
            System.out.println("--registration failed");
            throw new IncorrectRegistrationData("You already have an account. Please, login...");
        }

        if (inputPassword.equals(repeatedPassword)) {
            passwordMatch = true;
        }

        if (!passwordMatch) {
            System.out.println("--registration failed");
            throw new IncorrectRegistrationData("Not matching passwords! Please, try again...");
        }

        // Append username to the usernames file
        try (FileWriter fileWriter = new FileWriter(this.usernames, true)) {
            fileWriter.append(inputUsername + "\n"); // Ensure each entry is on a new line
        } catch (Exception exception) {
            System.out.println("--write error");
            return false;
        }

        // Append password to the passwords file
        try (FileWriter fileWriter = new FileWriter(this.passwords, true)) {
            fileWriter.append(inputPassword + "\n"); // Ensure each entry is on a new line
        } catch (Exception exception) {
            System.out.println("--write error");
            return false;
        }

        this.setNewUser(inputUsername, inputPassword);
        System.out.println("--registration successful");
        return true;
    }


    /**
     * setGameMode() sets the game mode based on the choice the user has made
     *
     * @param gameMode represents name of the game mode
     */
    public void setGameMode(String gameMode){// Refactored
        this.newUser.setGameMode(gameMode);
        this.newUser.updateBudget(this.newUser.getGameMode().getBudget());
        this.userStatusObserver.notifyListeners();
        setManagerOfNPC();
    }

    /**
     * This method sets up the user's vehicle based on the choice the user has made and handles also the budget and other dependencies
     *
     * @param vehicleName represents name/factory identity of the requested vehicle
     * @return boolean value based on the success state of the process
     */
    public boolean vehicleSetup(String vehicleName){
        // Set up the user vehicle
        /* Purchase validation - at this point it is unnecessary, usage only as budget update tool */

        if (!vehicleName.isEmpty()){
            CustomisedVehicle chosenVehicle = new CustomisedVehicle(new ConcreteVehicleFactory().createVehicle(vehicleName));
            this.newUser.setCustomisableVehicle(chosenVehicle);
        }else{
            return false;
        }
        try {
            this.newUser.updateBudget(affectBudget(this.newUser.getVehicle().getPrice()));
        }catch(Exception e){
            return false;
        }

        // Observer used here to track the specs and budget
        this.userStatusObserver.notifyListeners();
        // Logger
        System.out.println("--vehicle assigned: " + this.newUser.getVehicle().getBrand()+ " " +
                this.newUser.getVehicle().getModel() + " " + this.newUser.getVehicle().getProductionYear());
        return true;
    }

    /**
     * Extracts vehicle specifications from {@link CustomisedVehicle}
     *
     * @return list of specifications
     */
    public ArrayList<String> getVehicleSpecs(){
        ArrayList<String> result = new ArrayList<>();
        CustomisedVehicle vehicle = this.newUser.getVehicle();
        result.add(vehicle.getBrand());
        result.add(vehicle.getModel());
        result.add(Integer.toString(vehicle.getProductionYear()));
        result.add(Integer.toString(vehicle.getHorsePower()));
        result.add(Integer.toString(vehicle.getTorque()));
        // Round acceleration
        double acceleration = Math.floor(vehicle.getAcceleration()*10)/10;
        result.add(Double.toString(acceleration));

        result.add(Integer.toString(vehicle.getMaxSpeed()));
        result.add(Integer.toString(vehicle.getWeight()));
        result.add(Integer.toString(vehicle.getPrice()));

        return result;
    }

    /**
     * Adds another particle to the List<ParticleManufacture> particles: GameManager.user.customisedVehicle.particles
     *
     * @param addRequest represents name of the particle/factory identity
     * @return
     */
    public boolean addParticle(String addRequest){

        if (!addRequest.isEmpty()){
            try{
                ParticleManufacture newParticle = new ConcreteParticleFactory().createParticle(addRequest);
                newUser.updateBudget(affectBudget(newParticle.getPrice()));
                this.newUser.getVehicle().addParticle(newParticle);
                System.out.println("--particle assignation success");

                // Observer used here to track the specs and budget
                this.userStatusObserver.notifyListeners();
                return true;

            }catch (Exception e){
                System.out.println("--particle assignation failure: insufficient funds");
                return false;
            }
        }else{
            // Logger
            System.out.println("--particle assignation failure");
            return false;
        }
    }

    /**
     * Removes particle from List<ParticleManufacture> particles: GameManager.user.customisedVehicle.particles
     *
     * @param removeRequest represents name/factory identity of the particle
     **/
    public void removeParticle(String removeRequest){// refactored
        if (!removeRequest.isEmpty()){
            try{
                ParticleManufacture deletedParticle = newUser.getVehicle().removeParticle(removeRequest);
                newUser.updateBudget(refund(deletedParticle.getPrice()));
                System.out.println("--Particle unassigned");
//                this.appUI.displayAnnouncement("Particle successfully removed!");

                // Observer used here to track the specs and budget
                this.userStatusObserver.notifyListeners();

            }catch (Exception e){
                System.out.println("--Particle managing failure");
//                this.appUI.displayErrorMessage("Particle was not attached to the vehicle or doesn't exist: " + e.getMessage());// Error panel in GUI
            }
        }else{
            System.out.println("--Particle managing failure");
//            this.appUI.displayErrorMessage("Particle was not chosen... You are being redirected to the add/remove page");// Error panel in GUI
        }
//        this.appUI.showLoadingCircle();
    }


    /**
     * Handles budget affection - checks possible increasing/decreasing of the budget
     *
     * @param affectValue - value which will affect the budget
     * @return budget - affectValue
     * @throws InsufficientFunds - negative remainder handling
     */
    private int affectBudget(int affectValue) throws InsufficientFunds {
        int result = newUser.getBudget() - affectValue;
        if (result >= 0){
            return  result;
        }else {
            throw new InsufficientFunds();
        }
    }

    /**
     * Handles refunds for example when a particle is removed from vehicle
     *
     * @param refundValue value of the particle
     * @return new budget
     */
    private int refund(int refundValue){
        return newUser.getBudget() + refundValue;
    }

    /**
     * Getter
     *
     * @return int - actual budget value
     */
    public int displayBudget(){
        return newUser.getBudget();
    }


    /**
     * Works as getter to manipulate the newUser
     *
     * @return newUser instance
     */
    public UserRecognition getNewUser(){
        return this.newUser;
    }

    /**
     * Initializes new user representation
     *
     * @param username - Name of the user extracted from GUI
     * @param password - Password extracted from GUI
     */
    public void setNewUser(String username, String password){
        this.newUser = new User(username, password);
    }

    /**
     * Getter
     *
     * @return {@link VotingControl} - object which controls the voting process
     */
    public VotingControl getVotingControl(){
        return this.votingControl;
    }

    /**
     * Fills the voting dataset
     */
    public void prepareVoteDataset(){
        // Get voting statistics from NPCs
        votingControl.fillCompositeByEnemies(managerOfNPC.getEnemies());

        // Add the current user to the voting statistics
        votingControl.addUser(newUser);
    }

    /**
     * Handles voting process of the user, validates candidate
     *
     * @param candidate - extracted from GUI - user's vote
     * @return the validated vote if success, otherwise null
     */
    public UserRecognition vote(String candidate) {
//        String candidate = this.appUI.getVoteCandidate(votingControl.getVotingStatistic());
        // Give vote to the favourite vehicle/owner
        this.newUser.setFavourite(candidate);
        UserRecognition favourite = this.votingControl.getVotingStatistic().get(this.newUser.giveVote());

        if (favourite == null){
            return null;
        }

        this.newUser.voteForVehicle(this.votingControl.getVotingStatistic());

        // Now let NPCs vote
        this.managerOfNPC.voteAll(this.votingControl.getVotingStatistic());

        // Set the winner based on the voting statistics
        votingControl.setWinner();

        // If success: return favourite so the controller knows the result of the operation
        // and return is not always null
        return favourite;
    }
}