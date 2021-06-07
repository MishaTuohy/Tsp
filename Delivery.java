// Data model class for storing delivery data
class Delivery {
    // Properties
    private final int orderNumber;
    private final String address;
    private final int minutesWaiting;
    private final double x;
    private final double y;

    // Constructor
    public Delivery(int orderNumber, String address, int minutesWaiting,double x, double y) {
        this.orderNumber = orderNumber;
        this.address = address;
        this.minutesWaiting = minutesWaiting;
        this.x = x;
        this.y = y;
    }

    // Getters and Setters
    public int getOrderNumber() {
        return orderNumber;
    }
    public double getX() { return x; }
    public double getY() {return y;}

    // To string method
    @Override
    public String toString() {
        return "Delivery Order Number: " + orderNumber + "\n" +
                "    Address: " + address + "\n" +
                "    Minutes waiting: " + minutesWaiting + "\n" +
                "    x co-ordinate: " + x + "\n" +
                "    y co-ordinate: " + y + "\n"
                + "";
    }
}