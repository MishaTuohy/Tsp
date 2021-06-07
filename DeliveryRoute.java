import java.util.ArrayList;
import java.util.List;

// Data model class and methods needed for storing delivery routes
class DeliveryRoute {
    // Attributes
    private final List<Delivery> deliveries;
    private double distance;

    // Constructors
    public DeliveryRoute(List<Delivery> deliveries) {
        this.deliveries = new ArrayList<>(deliveries);
    }

    // Methods
    public Delivery getDelivery(int index) {
        return deliveries.get(index);
    }

    // Gets the delivery route total distance
    public double getRouteDistance() {
        if(distance != 0)
            return distance;
        double totalDistance = 0;
        for(int i = 0; i < numOfDeliveries(); i++) {
            Delivery start = getDelivery(i);
            Delivery end = getDelivery(i + 1 < numOfDeliveries() ? i + 1 : 0);
            totalDistance += Utility.distance(start, end);
        }
        distance = totalDistance;
        return totalDistance;
    }

    // Creates a duplicate of the route
    public DeliveryRoute duplicate() {
        return new DeliveryRoute(new ArrayList<>(deliveries));
    }

    // Returns the number of deliveries in the route
    public int numOfDeliveries() {
        return deliveries.size();
    }

    // Getters and setters
    public List<Delivery> getDeliveries() {
        return deliveries;
    }
}