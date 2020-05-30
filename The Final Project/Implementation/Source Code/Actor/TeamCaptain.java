package Actor;

import AbstractObjects.Database;
import Exception.IDNotFound;
import Matches.Team;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class to represent a player that has created a team.
 * a team must have one Team Captain only
 */

public class TeamCaptain extends Player {

    public TeamCaptain(Player player) {
        this.name = player.name;
        this.ID = player.ID;
        this.wallet = player.wallet;
        this.password = player.password;
        this.email = player.email;
        this.address = player.address;
        this.mobile_num = player.mobile_num;
        this.bookings = player.bookings;
        this.team = player.team;
        this.team_invitations = new ArrayList<Team>();
    }

    /**
     * Invite a player to the captain's team
     */
    public void invite() throws IDNotFound {
        if(getTeam().getMembers().size() > 10){
            System.out.print("The team is full. you can't invite more players.");
            return;
        }

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the ID of the player you want to invite: ");
        int ID = Integer.parseInt(input.nextLine());

        Player player = Database.searchPlayer(ID);

        if(player == null){
            throw new IDNotFound();
        }
        else{
            if(player.getTeam() == null){
                player.getTeam_invitations().add(this.getTeam());
                System.out.println("The invitation was successfully sent.");
            }
            else{
                System.out.println("The player is already in a team. Invitation failed.");
            }
        }
    }

    /**
     * Main menu screen for team captain
     */
    @Override
    public void menu() {
        System.out.println("1) Invite player to team\n2) Book a playground\n3) View all playgrounds\n4) Search playgrounds by location\n5) Check wallet\n6) Search for an account by name\n7) Sign out");
    }
}
