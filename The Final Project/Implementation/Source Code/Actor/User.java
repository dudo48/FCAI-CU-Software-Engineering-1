package Actor;

import AbstractObjects.Database;
import ConsoleUI.Main;

import java.util.Scanner;

/**
 *  A class that is used for any user that has just opened the program. An unregistered user.
 */
public class User {
    /**
     * Allows the user to register to the program database.
     * An email can only be associated with one account. Thus it is used to identify duplicate accounts.
     */
    public void register() {
        Scanner input = new Scanner(System.in);

        System.out.println("Do you want to create an account as a:\n1) Player\n2) Playground Owner");
        int choice = Main.makeChoice(1, 2);

        System.out.print("Enter your Name: ");
        String name = input.nextLine();
        System.out.print("Enter your Password: ");
        String password = input.nextLine();
        System.out.print("Enter your Email: ");
        String email = input.nextLine();
        System.out.print("Enter your Address: ");
        String address = input.nextLine();
        System.out.print("Enter your Mobile Number: ");
        String mobile_num= input.nextLine();

        if(choice == 1){
            if(Database.isDuplicate(email, true)) {
                System.out.println("This email is already registered. Registration failed.");
            }
            else{
                Player account = new Player(name, password, email, address, mobile_num);
                Database.players_accounts.add(account);
                System.out.println("The account was successfully registered. Please log in.");
            }
        }
        else{
            if(Database.isDuplicate(email, false)) {
                System.out.println("This email is already registered. Registration failed.");
            }
            else{
                PlaygroundOwner account = new PlaygroundOwner(name, password, email, address, mobile_num);
                Database.playgroundOwners_accounts.add(account);
                System.out.println("The account was successfully registered. Please log in.");
            }
        }
    }

    /**
     * Login to a player account using email and password
     */
    public Player loginPlayer() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your Email: ");
        String email = input.nextLine();
        System.out.print("Enter your Password: ");
        String password = input.nextLine();

        return Database.verifyPlayer(email, password);
    }

    /**
     * Login to an owner account using email and password
     * The only difference between logins is calling a different database ArrayList
     */

    public PlaygroundOwner loginPlaygroundOwner() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your Email: ");
        String email = input.nextLine();
        System.out.print("Enter your Password: ");
        String password = input.nextLine();

        return Database.verifyPlaygroundOwner(email, password);
    }

    /**
     * Login to an admin account
     */

    public Admin loginAdmin() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your Email: ");
        String email = input.nextLine();
        System.out.print("Enter your Password: ");
        String password = input.nextLine();

        return Database.verifyAdmin(email, password);
    }

    /**
     * Main menu screen for the User class
     */
    public void menu(){
        System.out.println("1) Register\n2) Login\n3) Exit the Program");
    }
}
