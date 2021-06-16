import java.util.Collections;
import java.util.Scanner;

public class Tsp {
    final static Delivery pizzaPlace = new Delivery(0, "Pizza Place", 0, 53.41318, -6.71261);
    private static long endTime = 0;
    private static Scanner scan = new Scanner(System.in);
    private static double coolingFactor = 0.9999;
    private static int outerSpeed = 1; // outer loop count
    private static int innerSpeed = 1; // inner loop count
    private static String input =
            """
            1,38 Parsons Hall Maynooth ,4,53.37521,-6.6103
            2,34 Silken Vale Maynooth ,6,53.37626,-6.59308
            3,156 Glendale Leixlip ,18,53.37077,-6.48279
            4,33 The Paddocks Oldtown Mill Celbridge ,8,53.3473,-6.55057
            5,902 Lady Castle K Club Straffan ,11,53.31159,-6.60538
            6,9 The Park Louisa Valley Leixlip ,3,53.36115,-6.48907
            7,509 Riverforest Leixlip ,10,53.37402,-6.49363
            8,16 Priory Chase St.Raphaels Manor Celbridge ,7,53.33886,-6.55468
            9,13 Abbey Park Court Clane,13,53.2908,-6.67746
            10,117 Royal Meadows Kilcock ,12,53.39459,-6.66995
            11,7 Riverlawn Abbeyfarm Celbridge ,3,53.33239,-6.55163
            12,10 Fair Green Court Kilccock ,7,53.39847,-6.66787
            13,11 The Lodge Abbeylands Clane,12,53.29128,-6.67836
            14,628 Riverforest Leixlip ,5,53.37416,-6.49731
            15,12 Castlevillage Avenue Celbridge ,8,53.35298,-6.54921
            16,116 Connaught Street Kilcock ,4,53.39839,-6.66767
            17,44 Rinawade Avenue Leixlip ,20,53.36141,-6.51834
            18,35 Beech Park Wood Beech Park Leixlip ,14,53.36287,-6.52468
            19,96 Priory Lodge St. Raphael's Manor Celbridge ,2,53.33835,-6.53984
            20,33 Leinster Wood Carton Demesne Maynooth ,7,53.39351,-6.5542
            21,6 Glen Easton View Leixlip ,15,53.36883,-6.51468
            22,40 Oaklawn West. Leixlip ,8,53.36833,-6.50589
            23,169 Glendale Leixlip ,24,53.37043,-6.48193
            24,14 The Rise Louisa Valley Leixlip ,15,53.36115,-6.48907
            25,28 The Lawn Moyglare Abbey Maynooth ,7,53.38895,-6.60579
            26,43 The Woodlands Castletown Celbridge ,12,53.34678,-6.53415
            27,14 Rye River Crescent Dun Carraig Leixlip ,8,53.36518,-6.48913
            28,32 The View St.Wolstan Abbey Celbridge ,10,53.33751,-6.53173
            29,20 Habourview The Glenroyal Centre Maynooth ,9,53.37954,-6.58793
            30,416A Ballyoulster Celbridge ,5,53.34133,-6.51856
            31,10 Brookfield Avenue Maynooth ,8,53.36976,-6.59828
            32,15 Willow Rise Primrose Gate Celbridge ,19,53.33591,-6.53566
            33,3 Lyreen Park Maynooth ,26,53.38579,-6.58673
            34,2 Beaufield Drive Maynooth ,10,53.37414,-6.60028
            35,28 The Avenue Castletown Celbridge ,18,53.34514,-6.53615
            36,4 Abbey Park Grove Clane ,14,53.29206,-6.67685
            37,78 Crodaun Forest Park Celbridge ,15,53.35401,-6.54603
            38,1 Kyldar House Manor Mills Maynooth ,29,53.38122,-6.59226
            39,1002 Avondale Leixlip ,22,53.36869,-6.48314
            40,18 College Green Maynooth ,5,53.37247,-6.60044
            """;

    public static void main(String[] args) {
        CLI(1);
    }

    public static void CLI(int choice) {
        int userInput = 0;
        if(choice == 1 ) {

            System.out.println(
                    """
                    1. The Cooling Factor
                       - Type 1 for a Cooling Factor of 0.999
                       - Type 2 for a Cooling Factor of 0.9999
                       - Type 3 for a Cooling Factor of 0.99999
                    """
            );
            userInput = scan.nextInt();

            if(userInput == 1) coolingFactor = 0.999;
            else if(userInput == 2) coolingFactor = 0.9999;
            else if(userInput == 3) coolingFactor = 0.99999;
            else {
                System.out.println("Please type in a valid input for the Cooling Factor");
                CLI(1);
            }

            System.out.println(
                    """
                    2. The Outer Loop Count
                       - Type 1 for a Outer Loop of 1
                       - Type 2 for a Outer Loop of 5
                       - Type 3 for a Outer Loop of 10
                    """);
            userInput = scan.nextInt();

            if(userInput == 1) outerSpeed = 1;
            else if(userInput == 2) outerSpeed = 5;
            else if(userInput == 3) outerSpeed = 10;
            else {
                System.out.println("Please type in a valid input for the Outer Loop Count");
                CLI(2);
            }


            System.out.println(
                    """
                    3. The Inner Loop Count
                       - Type 1 for a Inner Loop of 1
                       - Type 2 for a Inner Loop of 5
                       - Type 3 for a Inner Loop of 10
                    """
            );
            userInput = scan.nextInt();

            if(userInput == 1) innerSpeed = 1;
            else if(userInput == 2) innerSpeed = 5;
            else if(userInput == 3) innerSpeed = 10;
            else {
                System.out.println("Please type in a valid input for the Inner Loop Count");
                CLI(3);
            }

        } else if (choice == 2) {

            System.out.println(
                    """
                    2. The Outer Loop Count
                       - Type 1 for a Outer Loop of 1
                       - Type 2 for a Outer Loop of 5
                       - Type 3 for a Outer Loop of 10
                    """);
            userInput = scan.nextInt();

            if(userInput == 1) outerSpeed = 1;
            else if(userInput == 2) outerSpeed = 5;
            else if(userInput == 3) outerSpeed = 10;
            else {
                System.out.println("Please type in a valid input for the Outer Loop Count");
                CLI(2);
            }


            System.out.println(
                    """
                    3. The Inner Loop Count
                       - Type 1 for a Inner Loop of 1
                       - Type 2 for a Inner Loop of 5
                       - Type 3 for a Inner Loop of 10
                    """
            );
            userInput = scan.nextInt();

            if(userInput == 1) innerSpeed = 1;
            else if(userInput == 2) innerSpeed = 5;
            else if(userInput == 3) innerSpeed = 10;
            else {
                System.out.println("Please type in a valid input for the Inner Loop Count");
                CLI(3);
            }

        } else if (choice == 3) {
            System.out.println(
                    """
                    3. The Inner Loop Count
                       - Type 1 for a Inner Loop of 1
                       - Type 2 for a Inner Loop of 5
                       - Type 3 for a Inner Loop of 10
                    """
            );
            userInput = scan.nextInt();

            if(userInput == 1) {
                innerSpeed = 1;
                Start();
            }
            else if(userInput == 2) {
                innerSpeed = 5;
                Start();
            }
            else if(userInput == 3) {
                innerSpeed = 10;
                Start();
            }
            else {
                System.out.println("Please type in a valid input for the Inner Loop Count");
                CLI(3);
            }
        }
        Start();
    }

    public static void Start() {
        long startTime = System.nanoTime(); // Start tracking program running time

        DeliveryRoute initialRoute = new DeliveryRoute(Utility.readDeliveryList(input, pizzaPlace)); // Takes in initial route 1 - 40
        DeliveryRoute output = start(initialRoute); // Uses initial route to start algorithm

        StringBuilder outputString = new StringBuilder(); // Start formatting answer
        for(Delivery d : output.getDeliveries())
            outputString.append(d.getOrderNumber()).append(" ");

        // Prints answer in console
        System.out.println("Final route:");
        System.out.println((endTime - startTime) / 1000000000 + " seconds");
        System.out.println(" " + outputString);
        System.out.println();
    }

    public static DeliveryRoute start(DeliveryRoute initialRoute) {
        // Prints initial route to console
        System.out.println();
        System.out.println("Initial Route");
        for(Delivery d : initialRoute.getDeliveries())
            System.out.print("  " + d.getOrderNumber());

        System.out.println();
        System.out.println();

        // Sets new min/fastest route
        DeliveryRoute min = initialRoute;
        DeliveryRoute result;

        // Runs a fresh program every iteration using initial route provided

        for(int i = 1; i <= outerSpeed; i++) {
            int count = 0;
            result = simulatedAnnealing(initialRoute, count);
            System.out.println(i + ". " + result.getRouteDistance());

            for(Delivery d : result.getDeliveries())
                System.out.print(" " + d.getOrderNumber());

            System.out.println();
            System.out.println();
            if(result.getRouteDistance() < min.getRouteDistance())
                min = result;
        }

        // Stops tracking program duration
        endTime = System.nanoTime();
        return min;
    }

    // This is the meat and potatoes
    public static DeliveryRoute simulatedAnnealing(DeliveryRoute deliveries, int count) {
        // Creates a current and a best route to compare against each other
        DeliveryRoute current = deliveries;
        DeliveryRoute best = current.duplicate();

        // Feeds the previous best route back into the algorithm and try finds the best route using a faster route

        if(count < innerSpeed) {
            // Resets temperature for new iteration
            double temperature = 10000;

            // Keeps going until the temperature reaches 1
            while(temperature > 1) {

                // Generates a neighbouring delivery route to compare to
                DeliveryRoute neighbor = current.duplicate();

                // Gets two random points in the delivery route
                int point1 = Utility.notZero((int) (neighbor.numOfDeliveries() * Math.random()), neighbor);
                int point2 = Utility.notZero((int) (neighbor.numOfDeliveries() * Math.random()), neighbor);

                // Prevents the points from being the same point and from being zero.
                while(point1 == point2)
                    point2 = Utility.notZero((int) (neighbor.numOfDeliveries() * Math.random()), neighbor);

                // Swaps the two random points in the neighbouring route
                Collections.swap(neighbor.getDeliveries(), point1, point2);

                // Gets the length of each routes
                double currentLength = current.getRouteDistance();
                double neighbourLength = neighbor.getRouteDistance();

                // Decides which route to choose depending on distance and the temperature
                if (Math.random() < Utility.probability(currentLength, neighbourLength, temperature))
                    current = neighbor.duplicate();

                // Keeps track of the best route so far
                if (current.getRouteDistance() < best.getRouteDistance())
                    best = current.duplicate();

                // Reduces the temperature

                temperature *= coolingFactor;
            }
            // Increasing count
            count++;

            // Restarts algorithm starting with the previously best route
            return simulatedAnnealing(best, count);
        } else  // If there are no more iterations return the best route
            return best;
    }
}