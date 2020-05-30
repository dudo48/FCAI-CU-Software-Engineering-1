package Actor;

import AbstractObjects.Booking;
import AbstractObjects.Database;
import AbstractObjects.IDGenerator;
import AbstractObjects.Wallet;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *  Class to resemble a user that has an account in the database in general.
 *  Player, PlaygroundOwner and Admin inherit from this class.
 */
public class LoggedUser {
    protected String name;
    protected String password;
    protected int ID;
    protected String email;
    protected String address;
    protected String mobile_num;
    protected Wallet wallet;

    public LoggedUser(String name, String password, String email, String address, String mobile_num) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.address = address;
        this.mobile_num = mobile_num;
        this.wallet = new Wallet();
        this.ID = IDGenerator.User();
    }

    public LoggedUser() { // empty constructor added to initialize team captain from a player without generating a new ID
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public int getID() {
        return ID;
    }

    // Allows LoggedUsers to search for an another user's Info using name.
    // If no matches were found in the three databases nothing will be printed.
    public void searchUserInfo(){
        System.out.print("Enter the Username of the User you want to check ID: ");
        Scanner input = new Scanner(System.in);
        String name_input = input.nextLine();

        for (int i = 0; i < Database.admins_accounts.size(); ++i){
            if(Database.admins_accounts.get(i).getName().equalsIgnoreCase(name_input)){
                System.out.println("An Admin with this name was found. ID: " + Database.admins_accounts.get(i).getID() + ", Email: " + Database.admins_accounts.get(i).getEmail());
            }
        }
        for (int i = 0; i < Database.playgroundOwners_accounts.size(); ++i){
            if(Database.playgroundOwners_accounts.get(i).getName().equalsIgnoreCase(name_input)){
                System.out.println("A Playground Owner with this name was found. ID: " + Database.playgroundOwners_accounts.get(i).getID() + ", Email: " + Database.playgroundOwners_accounts.get(i).getEmail());
            }
        }
        for (int i = 0; i < Database.players_accounts.size(); ++i){
            if(Database.players_accounts.get(i).getName().equalsIgnoreCase(name_input)){
                System.out.println("A Player with this name was found. ID: " + Database.players_accounts.get(i).getID() + ", Email: " + Database.players_accounts.get(i).getEmail());
            }
        }
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nEmail: " + email + "\nID: " + ID;
    }
}
