import MVC_pattern.AppController;
import MVC_pattern.ViewGUI;
import game.ManagerOfCharacters;
import game.UserRecognition;

import java.util.*;
import java.util.List;
/**
 * This class represents main class of this project, which is used to start and run application
 *
 *  @author Šimon Vinkler
 *  @version 1.0
 *  @since 1.3.2024
 */
public class Main {

    /**
     * This method starts and runs the whole application
     *
     * @param args arguments provided during execution starting by terminal prompt, not used in my implementation
     */
    public static void main(String[] args) {
        AppController appController = new AppController(new ViewGUI(), new ManagerOfCharacters());
        List<String> usernames = Arrays.asList(
                "SkyPilot", "WhisperWind", "LunarFlame", "EchoRider", "WildHeart",
                "ShadowWalker", "MysticSinger", "TigerEye", "DragonKnight", "StarSeeker",
                "SoulDancer", "AquaFrost", "EmberCrafter", "VortexRunner", "BlazeWarden",
                "FrostBloom", "StormChaser", "TwilightHunter", "PhoenixRider", "MoonShade",
                "SunsetStrider", "DreamWeaver", "CrimsonTide", "MistWeaver", "SablePhoenix",
                "SpiritDrifter", "SilentWhisper", "EternalFlame", "ShadeSeeker", "CelestialWanderer"
        );
        // Initialize HashMap for storing results of votes
        HashMap<String, UserRecognition> votingStatistic = new HashMap<String, UserRecognition>();

    }
}