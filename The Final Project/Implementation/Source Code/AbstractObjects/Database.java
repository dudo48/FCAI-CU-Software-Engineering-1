package AbstractObjects;

import java.util.ArrayList;
import Actor.Admin;
import Actor.Player;
import Actor.PlaygroundOwner;
import Matches.Playground;
import Exception.IDNotFound;

/**
 *  A class to store the necessary data registered in the program.
 *  has an Arraylist attribute for each category(Ex: players, playground owners).
 */
public class Database {
    public static ArrayList<Player> players_accounts = new ArrayList<Player>();
    public static ArrayList<PlaygroundOwner> playgroundOwners_accounts = new ArrayList<PlaygroundOwner>();
    public static ArrayList<Admin> admins_accounts = new ArrayList<Admin>();
    public static ArrayList<Playground> playgrounds = new ArrayList<Playground>(); // this array contains active playgrounds only
    public static ArrayList<Booking> bookings = new ArrayList<Booking>();

    /**
     * Verify a player account as stored in the database
     * @param email given email
     * @param password given password
     * @return null if account doesn't exist. otherwise returns the account
     */
    public static Player verifyPlayer(String email, String password){
        for(int i = 0; i < players_accounts.size(); ++i){
            if(players_accounts.get(i).getEmail().equalsIgnoreCase(email) && players_accounts.get(i).getPassword().equals(password)){
                return players_accounts.get(i);
            }
        }
        return null;
    }

    /**
     * Verify a playground owner account as stored in the database
     * @param email given email
     * @param password given password
     * @return null if account doesn't exist. otherwise returns the account
     */
    public static PlaygroundOwner verifyPlaygroundOwner(String email, String password){
        for(int i = 0; i < playgroundOwners_accounts.size(); ++i){
            if((playgroundOwners_accounts.get(i).getEmail().equalsIgnoreCase(email)) && (playgroundOwners_accounts.get(i).getPassword().equals(password))){
                return playgroundOwners_accounts.get(i);
            }
        }
        return null;
    }

    /**
     * Verify an admin account as stored in the database
     * @param email given email
     * @param password given password
     * @return null if account doesn't exist. otherwise returns the account
     */
    public static Admin verifyAdmin(String email, String password){
        for(int i = 0; i < admins_accounts.size(); ++i){
            if(admins_accounts.get(i).getEmail().equalsIgnoreCase(email) && admins_accounts.get(i).getPassword().equals(password)){
                return admins_accounts.get(i);
            }
        }
        return null;
    }

    /**
     * searches the playgrounds for the given playground ID
     */

    public static Playground searchPlayground(int ID) {
        for(int i = 0; i < playgrounds.size(); ++i){
            if(playgrounds.get(i).getID() == ID){
                return playgrounds.get(i);
            }
        }
        return null;
    }

    /**
     * Checks if the given email is already registered.
     * used for verification while registering
     * second parameter decides to search in players or playground owners array
     * true for players
     * false for playground owners
     */
    public static boolean isDuplicate(String email, boolean isPlayer){
        if(isPlayer){
            for(int i = 0; i < players_accounts.size(); ++i){
                if(players_accounts.get(i).getEmail().equalsIgnoreCase(email)){
                    return true;
                }
            }
        }
        else {
            for(int i = 0; i < playgroundOwners_accounts.size(); ++i){
                if(playgroundOwners_accounts.get(i).getEmail().equalsIgnoreCase(email)){
                    return true;
                }
            }
        }
        return false;
    }

    public static Player searchPlayer(int ID) {
        for(int i = 0; i < players_accounts.size(); ++i){
            if(players_accounts.get(i).getID() == ID){
                return players_accounts.get(i);
            }
        }
        return null;
    }
}
