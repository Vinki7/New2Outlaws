package game;

import MVC_pattern.AppController;

import java.io.*;
import java.util.HashMap;

/**
 * {@link User} is class which inherits from abstract class {@link Participant}, also implements {@link  Decision}, {@link Serializable} interfaces
 * Stores and manages user's data with methods like setPassword, giveVote, voteFor. Also contains foundations for serialisation which might be implemented later.
 *
 * @author Šimon Vinkler
 * @version Final
 * @since 1.3.2024
 */
public class User extends Participant implements Decision, Serializable {

    /**
     * This field is par of the foundation for serialisation and manages serial version
     */
    @Serial
    private static final long serialVersionUID = 1L;
    private transient String password;

    /**
     * Constructs the object and setts required data
     *
     * @param username is used for setting username of the current user
     * @param password is used for setting password of the current user
     */
    public User(String username, String password){
        setUsername(username);
        setPassword(password);
    }

    /**
     * Sets password of the user
     *
     * @param password is extracted from gui
     */
    protected void setPassword(String password){this.password = password;}

    /**
     * Provides password
     *
     * @return Password of the current user
     */
    public String getPassword(){return this.password;}

    /**
     * Provide vote
     *
     * @return name of the favourite player/vehicle of the user
     */
    @Override
    public String giveVote() {
        return getFavourite();
    }


    /**
     * Used for automated vote in EnemyAI, here fulfills function of voting platform. Handles the process of vote assignation.
     *
     * @param votingStatistic is a dataset to choose the user from
     */
    @Override
    public void voteForVehicle(HashMap<String, UserRecognition> votingStatistic) {
        UserRecognition voteFor =  votingStatistic.get(this.getFavourite());
        voteFor.addVote();
        votingStatistic.put(getFavourite(),voteFor);
        System.out.println("--user voted for: " + getFavourite());
    }

    /**
     * Stores state of the object, foundation for future implementations
     *
     * @return true/false based on the success of the process
     */
    public boolean serialisation(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/game/"+this.getUsername()+".ser"))) {
            oos.writeObject(this);
            System.out.println("--Save successful");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("--Save failed");
        }
        return false;
    }

    /**
     * Loads the state of the object from file
     *
     * @return {@link User} object which represents stored object or null if the operations inside the method failed
     */
    public User deSerialisation(){
        User user = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/game/"+this.getUsername()+".ser"))) {
            user = (User) ois.readObject();
            System.out.println("--Load successful");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }
}
