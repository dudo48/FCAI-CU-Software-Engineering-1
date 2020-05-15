package Actor;

import AbstractObjects.Booking;
import AbstractObjects.Database;
import AbstractObjects.IDGenerator;
import AbstractObjects.Wallet;

import java.util.ArrayList;

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

    public String getPassword() {
        return password;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nEmail: " + email + "\nID: " + ID;
    }
}
