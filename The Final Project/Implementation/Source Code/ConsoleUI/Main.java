// This is a console implementation of project GoFo
// The wallet is initialized by default to 1000 pounds to test some functionalities
// An admin, player and playground owners accounts were added to Database class for testing

package ConsoleUI;

import AbstractObjects.Database;
import Actor.*;
import Exception.*;
import Matches.Playground;

import java.util.Scanner;

public class Main {
    /**
     *  Function the takes an integer choice from the user and returns the choice.
     *  Used for main interaction with Console UI.
     *  Has a lower and upper value to force user input to be in the range
     * @return the choice entered by the player
     */
    public static int makeChoice(int lower, int upper){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your choice: ");
        int choice = Integer.parseInt(input.nextLine());

        while(choice < lower || choice > upper){
            System.out.println("Please enter a valid number matching your choice. ");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(input.nextLine());
        }

        return choice;
    }

    public static void main(String[] args) throws IDNotFound, IDNotFound {

        // added some accounts just to test functionalities
        Database.admins_accounts.add(new Admin("a", "a", "a", "a", "a"));
        Database.players_accounts.add(new Player("a", "a", "a", "a", "a"));
        Database.playgroundOwners_accounts.add(new PlaygroundOwner("a", "a", "a", "a", "a"));

        // Welcome messages.
        System.out.println("Welcome to GoFo.");
        System.out.println("You can interact with the UI by entering the number matching your choice.");
        System.out.println("You're currently unregistered. If you do not have an account then register.");
        System.out.println("If you have an account then log in.");

        // Main loop of the program.
        User user = new User();
        while(true){
            // menu screen
            user.menu();
            int choice = makeChoice(1, 3);

            // register choice
            if(choice == 1) {
                user.register();
            }

            // login choice
            else if(choice == 2){
                System.out.println("Do you want to log in to a:\n1) Player account\n2) Playground Owner account\n3) Admin account");
                choice = makeChoice(1, 3);

                // player choice
                if(choice == 1){
                    Player account = user.loginPlayer();

                    if(account == null) {
                        System.out.println("Failed to log in. invalid credentials.");
                    }

                    // logged in as a player and is the captain of his team
                    else if((account.getTeam() != null) && (account.getTeam().getCaptain().getEmail().equals(account.getEmail()))){
                        System.out.println("Logged in successfully.");
                        TeamCaptain captain_account = new TeamCaptain(account);
                        while(true) {
                            captain_account.menu();
                            choice = makeChoice(1, 6);
                            if(choice == 1){
                                captain_account.invite();
                            }
                            else if(choice == 2){
                                captain_account.bookPlayground();
                            }
                            else if(choice == 3){
                                captain_account.printPlaygrounds();
                            }
                            else if(choice == 4){
                                account.searchPlaygroundsLocation();
                            }
                            else if(choice == 5){
                                System.out.println("Your current balance is: " + account.getWallet().getMoney());
                            }
                            else{
                                System.out.println("You've signed out.");
                                break;
                            }
                        }
                    }

                    // logged in as a player and is not captain of his team or is not in a team
                    else{
                        System.out.println("Logged in successfully.");
                        while(true){
                            account.menu();
                            choice = makeChoice(1, 8);
                            if(choice == 1){
                                account.createTeam();
                                System.out.println("Please log in again to update your account.");
                                break; // had to log out a player who has just created a team to enter the loop of TeamCaptain
                            }
                            else if(choice == 2){
                                account.printInvitations();
                            }
                            else if(choice == 3){
                                account.accept();
                            }
                            else if(choice == 4){
                                account.bookPlayground();
                            }
                            else if(choice == 5){
                                account.printPlaygrounds();
                            }
                            else if(choice == 6){
                                account.searchPlaygroundsLocation();
                            }
                            else if(choice == 7){
                                System.out.println("Your current balance is: " + account.getWallet().getMoney());
                            }
                            else{
                                System.out.println("You've signed out.");
                                break;
                            }
                        }
                    }
                }

                // playground owner choice
                else if(choice == 2){
                    PlaygroundOwner account = user.loginPlaygroundOwner();

                    if(account == null) {
                        System.out.println("Failed to log in. invalid credentials.");
                    }

                    // logged in as a playground owner
                    else{
                        System.out.println("Logged in successfully.");
                        while(true) {
                            account.menu();
                            choice = makeChoice(1, 4);
                            if(choice == 1){
                                account.addPlayground();
                            }
                            else if(choice == 2){
                                account.printPlaygrounds();
                            }
                            else if(choice == 3) {
                                System.out.println("Your current balance is: " + account.getWallet().getMoney());
                            }
                            else{
                                System.out.println("You've signed out.");
                                break;
                            }
                        }
                    }
                }
                else{
                    Admin account = user.loginAdmin();

                    if(account == null) {
                        System.out.println("Failed to log in. invalid credentials.");
                    }

                    // logged in as an admin
                    else{
                        System.out.println("Logged in successfully.");
                        while(true) {
                            account.menu();
                            choice = makeChoice(1, 3);

                            if(choice == 1){
                                account.printRequests();
                            }
                            else if(choice == 2){
                                account.accept();
                            }
                            else{
                                System.out.println("You've signed out.");
                                break;
                            }
                        }
                    }
                }
            }

            // quit the program choice
            else {
                break;
            }
        }
    }
}
