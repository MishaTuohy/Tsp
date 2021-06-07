import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Just a utility class
class Utility {
    // Determines whether it accepts the new route
    public static double probability(double currentDistance, double newDistance, double temperature) {
        // If its a better route, accept the route
        if (newDistance <= currentDistance) return 1.0;
        // If it is a worse route, calculate the probability of accepting it anyways
        return Math.exp((currentDistance - newDistance) / temperature);
    }

    // Calculates distance using haversine formula
    public static double distance(Delivery city1, Delivery city2) {
        final int R = 6371; // Radius of the earth
        double latDistance = Math.toRadians(city1.getX() - city2.getX());
        double lonDistance = Math.toRadians(city1.getY() - city2.getY());
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(city1.getX())) * Math.cos(Math.toRadians(city2.getX()))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = (R * c * 1000); // convert to meters
        double height = 0.0;
        distance = Math.pow(distance, 2) + Math.pow(height, 2);
        return (int) Math.sqrt(distance);
    }

    // Generates a List of deliveries
    public static List<Delivery> readDeliveryList(String addressInput, Delivery startingPoint) {
        List<Delivery> deliveries = new ArrayList<>();
         deliveries.add(0, startingPoint); // Adds the pizza place to the beginning of the list so the algorithm starts there

        // Splits the user input by the line breaks so it can be processed
        String[] deliveriesStringList = addressInput.split("[\\n]");

        // Iterates through the lines of delivery data
        for(String s : deliveriesStringList) {

            // Breaks it down further into the individual bits of relevant information
            List<String> deliveriesStringListBoob = Arrays.asList(s.split("[,]"));

            // Following code adds data to the current delivery object, then adds it to a List of deliveries
            int orderNumber = 0;
            String address = "";
            int minutesWaiting = 0;
            double x = 0;
            double y = 0;
            int count = 0;

            // We know which index is going to be which piece of data so i just made some if statements to input data to delivery object
            while(count < 5) {
                if(count % 5 == 0) {
                    orderNumber = Integer.parseInt(deliveriesStringListBoob.get(count).trim());
                    count++;
                } else if(count == 1) {
                    address = deliveriesStringListBoob.get(count);
                    count++;
                } else if(count == 2) {
                    minutesWaiting = Integer.parseInt(deliveriesStringListBoob.get(count));
                    count++;
                } else if(count == 3) {
                    x = Double.parseDouble(deliveriesStringListBoob.get(count));
                    count++;
                } else if(count == 4) {
                    y = Double.parseDouble(deliveriesStringListBoob.get(count));
                    count++;
                }
            }
            Delivery newDelivery = new Delivery(orderNumber, address, minutesWaiting, x, y);
            deliveries.add(newDelivery);
        }
        return  deliveries;
    }

    // Makes sure the points are not zero
    public static int notZero(int point, DeliveryRoute neighbour) {
        if(point == 0)
            return notZero((int) (neighbour.numOfDeliveries() * Math.random()) , neighbour);
        else
            return point;
    }
}