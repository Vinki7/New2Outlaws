package game.ObserverDP;

import java.util.ArrayList;

/**
 * This class represents UserStatusObserver, which is used to notify all listeners about user status change
 * 
 *  @author Šimon Vinkler
 *  @version 1.0
 *  @since 1.3.2024
 */
public class UserStatusObserver {

    /**
     * List of listeners
     */
    private final ArrayList<UserStatusListener> listeners;

    /**
     * Constructor for UserStatusObserver
     */
    public UserStatusObserver(){
        listeners = new ArrayList<>();
    }

    /**
     * Method used to add listener to the list
     * 
     * @param listener represents listener which is added to the list
     */
    public void addListener(UserStatusListener listener){
        this.listeners.add(listener);
    }

    /**
     * Method used to remove listener from the list
     * 
     * @param listener represents listener which is removed from the list
     */
    public void removeListener(UserStatusListener listener){
        this.listeners.remove(listener);
    }

    /**
     * Method used to notify all listeners about user status change
     */
    public void notifyListeners() {
        listeners.forEach(UserStatusListener::update);// Method reference used her
    }
}
