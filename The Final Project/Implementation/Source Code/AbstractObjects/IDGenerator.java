package AbstractObjects;

/**
 * A class to generate unique IDs for different categories in the program
 * has methods resembling the different categories. each method returns a unique ID for that category.
 */

public class IDGenerator {
    private static int booking_ID = 0;
    private static int request_ID = 0;
    private static int wallet_ID = 0;
    private static int user_ID = 0;
    private static int team_ID = 0;
    private static int playground_ID = 0;

    public static int Booking(){
        ++booking_ID;
        return booking_ID;
    }
    public static int Request(){
        ++request_ID;
        return request_ID;
    }
    public static int Wallet(){
        ++wallet_ID;
        return wallet_ID;
    }
    public static int User(){
        ++user_ID;
        return user_ID;
    }
    public static int Team(){
        ++team_ID;
        return team_ID;
    }
    public static int Playground(){
        ++playground_ID;
        return playground_ID;
    }
}
