package AbstractObjects;

/**
 * A class represents the wallet that saves a user's money
 */

public class Wallet {

    private int ID;
    private double money;

    /**
     * Default constructor to initialize the attributes.
     */
    public Wallet() {
        this.ID = IDGenerator.Wallet();
        this.money = 1000;
    }

    /**
     * setMoney method to set the value of the money.
     * @param money
     */
    public void setMoney(double money) {
        this.money = money;
    }

    /**
     * getMoney method to return the value of the money.
     * @return
     */
    public double getMoney() {
        return money;
    }

    public int getID() {
        return ID;
    }

    /**
     * printMoney method to print the amount of the money.
     */
    public void printMoney() {
        System.out.println("Your current balance is: " + getMoney());
    }

}
