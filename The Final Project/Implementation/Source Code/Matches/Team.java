package Matches;

import AbstractObjects.IDGenerator;
import Actor.Player;
import Actor.TeamCaptain;

import java.util.ArrayList;

/**
 * A class to represent a team which has 1 captain and up to 10 players(members)
 */

public class Team {
    private String name;
    private int ID;
    private ArrayList<Player> members; // array of players in the team not including the team captain. maximum number of members is 10
    private TeamCaptain captain; // each team must have a captain

    public Team(String name, Player captain) {
        this.name = name;
        this.members = new ArrayList<Player>();
        this.captain = new TeamCaptain(captain);
        this.ID = IDGenerator.Team();
    }

    public TeamCaptain getCaptain() {
        return captain;
    }

    public int getID() {
        return ID;
    }

    public ArrayList<Player> getMembers() {
        return members;
    }

    @Override
    public String toString() {
        return "Team name: " + name +
                "\nTeam ID: " + ID +
                "\nTeam Captain Email: " + captain.getEmail();
    }
}
