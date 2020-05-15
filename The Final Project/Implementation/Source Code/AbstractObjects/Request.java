package AbstractObjects;

import Matches.Playground;

/**
 * A class that represents a request made by a playground owner to admins to add a playground
 */

public class Request {

    private int ID;
    private Playground playground;

    /**
     * Parameterized constructor to give the attributes a certain value.
     * @param playground Initialize a request with the requested playground
     */
    public Request(Playground playground) {

        this.playground = playground;
        this.ID = IDGenerator.Request();
    }

    /**
     * setID method to set the value of ID attribute.
     * @param ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * getID method to return the value of ID attribute.
     * @return
     */
    public int getID() {
        return ID;
    }

    /**
     * get method to return the requested playground
     * @return
     */
    public Playground getPlayground() {
        return playground;
    }
}

