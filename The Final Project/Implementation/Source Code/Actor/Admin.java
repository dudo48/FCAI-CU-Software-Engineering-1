package Actor;

import AbstractObjects.Booking;
import AbstractObjects.Database;
import AbstractObjects.Request;
import Matches.Playground;
import Exception.IDNotFound;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A user that has special control over the program, such as accepting playgrounds.
 */

public class Admin extends LoggedUser {
    public static ArrayList<Request> requests = new ArrayList<Request>();

    public Admin(String name, String password, String email, String address, String mobile_num) {
        super(name, password, email, address, mobile_num);
    }

    /**
     * a static function called for creating a new request for a new playground
     * @param playground
     */
    public static void request(Playground playground){
        Request req = new Request(playground);
        requests.add(req);
    }

    /**
     * Prints all the requested playgrounds
     */
    public void printRequests(){
        for(int i = 0; i < requests.size(); ++i){
            System.out.println("\n\nRequest ID: " + requests.get(i).getID());
            System.out.println(requests.get(i).getPlayground());
        }
    }

    /**
     * accept a playground in the requests array
     */

    public void accept() throws IDNotFound {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the ID of the request you want to accept: ");
        int ID = Integer.parseInt(input.nextLine());

        for(int i = 0; i < requests.size(); ++i){
            if(requests.get(i).getID() == ID){
                requests.get(i).getPlayground().setActive(true);
                Database.playgrounds.add(requests.get(i).getPlayground());
                requests.remove(i);
                System.out.println("Playground was approved.");
                return;
            }
        }
        throw new IDNotFound();
    }

    /**
     * main menu screen for admin account
     */
    public void menu(){
        System.out.println("1) Print Requests\n2) Approve a Playground\n3) Sign out");
    }
}
