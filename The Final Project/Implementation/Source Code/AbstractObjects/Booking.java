package AbstractObjects;


/**
 * Class representing a booking made by a player to a playground.
 * contains required attributes for details regarding the booking
 */
public class Booking {

    private int ID;
    private int booker_ID;
    private int booked_ID;
    private int day;
    private int month;
    private int start_hour;
    private int hours;

    public Booking(int booker_ID, int booked_ID, int day, int month, int start_hour, int hours) {

        this.ID = IDGenerator.Booking();
        this.booker_ID = booker_ID;
        this.booked_ID = booked_ID;
        this.day = day;
        this.month = month;
        this.start_hour = start_hour;
        this.hours = hours;

    }

    public int getID() {
        return ID;
    }

    /**
     * getBookerID method to return the value of booker_ID attribute.
     * @return
     */
    public int getBookerID() {
        return booker_ID;
    }

    /**
     * getBookedID method to return the value of booked_ID attribute.
     * @return
     */
    public int getBookedID() {
        return booked_ID;
    }

    /**
     * getDay method to return the value of day attribute.
     * @return
     */
    public int getDay() {
        return day;
    }

    /**
     * getMonth method to return the value of the month attribute.
     * @return
     */
    public int getMonth() {
        return month;
    }

    /**
     * getStartHour method to return the value of start_hour attribute.
     * @return
     */
    public int getStartHour() {
        return start_hour;
    }

    /**
     * getHours method to return the value of hours attribute.
     * @return
     */
    public int getHours() {
        return hours;
    }

    /**
     * printDescription method to print the information of the class.
     */
    public void printDescription() {
        System.out.print("The booking ID is: " + getID() + "/nThe booker ID is: " + getBookerID() + "/nThe booked playground ID is: "
                + getBookedID() + "/nTHe booking day is: " + getDay() + "/nThe booking month is: " + getMonth()
                + "/nThe booking start hour is: " +getStartHour() + "/nThe booking hours is: " + getHours());
    }
}
