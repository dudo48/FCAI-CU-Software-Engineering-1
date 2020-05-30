package Actor;

import AbstractObjects.Database;
import Matches.Playground;

/**
 * Class to represent a registered Playground Owner.
 * Has all attributes of a LoggedUser + an array of grounds resembling playgrounds owned.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class PlaygroundOwner extends LoggedUser {
    private ArrayList<Playground> grounds;


    public PlaygroundOwner(String name, String password, String email, String address, String mobile_num) {
        super(name, password, email, address, mobile_num);
        grounds = new ArrayList<Playground>();
    }

    /**
     * Add a new playground and wait for it to be accepted by an admin
     */
    public void addPlayground() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the Playground name: ");
        String name = input.nextLine();
        System.out.print("Enter the Playground location: ");
        String location = input.nextLine();
        System.out.print("Enter the Playground booking cost per hour: ");
        double cost_per_hour = Double.parseDouble(input.nextLine());
        System.out.print("Does the playground have natural grass? (y/n): ");
        String boolean_input = input.nextLine();
        boolean natural_grass;
        if(boolean_input.equalsIgnoreCase("y")){
            natural_grass = true;
        }
        else{
            natural_grass = false;
        }
        System.out.print("Enter the opening day number for the playground(between [0, 6] if day 0 is Saturday): ");
        int lower = Integer.parseInt(input.nextLine());
        System.out.print("Enter the closing day number for the playground(between [0, 6] if day 0 is Saturday): ");
        int upper = Integer.parseInt(input.nextLine());

        // loop to iterate and assign true to the days between lower and upper limit
        boolean[] work_days = new boolean[7];
        for(int i = 0; i < 7; ++i){
            if(i >= lower && i < upper){
                work_days[i] = true;
            }
            else{
                work_days[i] = false;
            }
        }

        System.out.print("Enter the opening hour for the playground(between [0, 23]if 0 is 12 AM): ");
        lower = Integer.parseInt(input.nextLine());
        System.out.print("Enter the closing hour for the playground(between [0, 23] if 0 is 12 AM): ");
        upper = Integer.parseInt(input.nextLine());

        // loop to iterate and assign true to the days between lower and upper limit
        boolean[] work_hours = new boolean[24];
        for(int i = 0; i < 24; ++i){
            if(i >= lower && i < upper){
                work_hours[i] = true;
            }
            else{
                work_hours[i] = false;
            }
        }

        System.out.print("Enter the Playground length in metres: ");
        int length = Integer.parseInt(input.nextLine());
        System.out.print("Enter the Playground width in metres: ");
        int width = Integer.parseInt(input.nextLine());

        Playground playground = new Playground(name, location, natural_grass, work_days, work_hours, cost_per_hour, length, width, this);
        grounds.add(playground);
        Admin.request(playground);
        System.out.println("Your request for the playground has been successfully created.");
        System.out.println("Wait for an admin to accept your request for the playground to be activated.");
    }

    /**
     * Print all playgrounds owned. whether activated or not.
     */
    public void printPlaygrounds(){
        for(int i = 0; i < grounds.size(); ++i){
            System.out.println(grounds.get(i));
        }
    }

    /**
     * Main menu for the playground owner account
     */
    public void menu(){
        System.out.println("1) Add playground\n2) View owned playgrounds\n3) Check wallet\n4) Search for an account by name\n5) Sign out");
    }
}
