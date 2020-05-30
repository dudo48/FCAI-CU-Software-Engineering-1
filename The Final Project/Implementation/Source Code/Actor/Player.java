package Actor;

import AbstractObjects.Booking;
import AbstractObjects.Database;
import Matches.Playground;
import Matches.Team;
import java.util.ArrayList;
import java.util.Scanner;
import Exception.*;

/**
 * Class to represent a registered Player.
 */

public class Player extends LoggedUser {

    protected Team team;
    protected ArrayList<Team> team_invitations;
    protected ArrayList<Booking> bookings;

    public Player(String name, String password, String email, String address, String mobile_num) {
        super(name, password, email, address, mobile_num);
        bookings = new ArrayList<Booking>();
        team_invitations = new ArrayList<Team>();
        team = null;
    }

    public Player() { // empty constructor added to initialize team captain from a player without generating a new ID
    }

    public Team getTeam() {
        return team;
    }

    public ArrayList<Team> getTeam_invitations() {
        return team_invitations;
    }

    /**
     * Book a playground
     * The user enters the id of the playground then the function searches for the playground in each
     * playground owner account
     */
    public void bookPlayground() throws IDNotFound {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the ID of the playground you want to book: ");
        int ID = Integer.parseInt(input.nextLine());

        // search if the playground exists and is active
        Playground playground = Database.searchPlayground(ID);
        if(playground == null){
            throw new IDNotFound();
        }

        System.out.print("Enter the month you want to book in(1 - 12): ");
        int month = Integer.parseInt(input.nextLine());

        System.out.print("Enter the day you want to book in(1 - 31): ");
        int day = Integer.parseInt(input.nextLine());

        System.out.print("Enter the start hour you want to book in(0 - 23): ");
        int start_hour = Integer.parseInt(input.nextLine());

        System.out.print("Enter the amount of hours you want to book(0 - 23): ");
        int hours = Integer.parseInt(input.nextLine());

        while(start_hour + hours > 24){
            System.out.println("Invalid booking time. Please reenter start hour and amount of hours.");
            System.out.print("Enter the start hour you want to book in(0 - 23): ");
            start_hour = Integer.parseInt(input.nextLine());

            System.out.print("Enter the amount of hours you want to book(0 - 23): ");
            hours = Integer.parseInt(input.nextLine());
        }

        double cost = playground.getCost_per_hour() * hours;

        System.out.println("The total cost of the booking is: " + cost);

        if(cost > wallet.getMoney()){
            throw new NotEnoughMoney();
        }

        wallet.setMoney(wallet.getMoney() - cost);
        playground.getOwner().wallet.setMoney(playground.getOwner().wallet.getMoney() + cost);

        Booking booking = new Booking(this.ID, ID, day, month, start_hour, hours);
        Database.bookings.add(booking);
    }

    /**
     * Prints activated playgrounds in the database
     */
    public void printPlaygrounds(){
        for(int i = 0; i < Database.playgrounds.size(); ++i){
            System.out.println(Database.playgrounds.get(i));
        }
    }

    /**
     * Prints playground with location filter entered by the player.
     */
    public void searchPlaygroundsLocation(){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the location you want to see playgrounds in: ");
        String location = input.nextLine();

        for(int i = 0; i < Database.playgrounds.size(); ++i){
            if(Database.playgrounds.get(i).getLocation().equalsIgnoreCase(location)) {
                System.out.println(Database.playgrounds.get(i));
            }
        }
    }

    /**
     * Print all team invitations
     */
    public void printInvitations(){
        for (int i = 0; i < team_invitations.size(); ++i){
            System.out.println(team_invitations.get(i));
        }
    }

    /**
     * Creating a new team.
     * The player must not be in a team to create his own team
     * the team creator is automatically assigned as the team captain
     */
    public void createTeam(){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the name of the Team: ");
        String name = input.nextLine();

        this.team = new Team(name, this);
        System.out.println("Your team was successfully created");
    }

    /**
     * Accepting a team that invited the player
     */
    public void accept(){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the ID of the team you want to accept: ");
        int ID = Integer.parseInt(input.nextLine());

        for(int i = 0; i < team_invitations.size(); ++i){
            if(team_invitations.get(i).getID() == ID){
                team = team_invitations.get(i);
                team_invitations.get(i).getMembers().add(this);
                team_invitations.clear();
                System.out.println("You joined the team successfully.");
                return;
            }
        }
        System.out.println("The team with this ID did not invite you or it doesn't exist.");
    }

    /**
     * Main menu screen for the player
     */
    public void menu(){
        System.out.println("1) Create team\n2) View team invites\n3) Accept a team invitation\n4) Book a playground\n5) View all playgrounds\n6) Search playgrounds by location\n7) Check wallet\n8) Search for an account by name\n9) Sign out");
    }
}
