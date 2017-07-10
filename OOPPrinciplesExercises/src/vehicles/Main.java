package vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {
    private static Vehicle car;
    private static Vehicle truck;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] carInfo = reader.readLine().split("\\s+");
        String[] truckInfo = reader.readLine().split("\\s+");

        double carFuelQuantity = Double.parseDouble(carInfo[1]);
        double carConsumptionPerKm = Double.parseDouble(carInfo[2]);

        double truckFuelQuantity = Double.parseDouble(truckInfo[1]);
        double truckConsumptionPerKm = Double.parseDouble(truckInfo[2]);

        car = new Car(carFuelQuantity, carConsumptionPerKm);
        truck = new Truck(truckFuelQuantity, truckConsumptionPerKm);
        int count = Integer.parseInt(reader.readLine());

        for (int i = 0; i < count; i++) {
            String[] commandInfo = reader.readLine().split("\\s+");
            String command = commandInfo[0];
            switch (command) {
                case "Drive":
                    if (commandInfo.length == 3) {
                        drive(commandInfo);
                    }
                    break;
                case "Refuel":
                    if (commandInfo.length == 3) {
                        refuel(commandInfo);
                    }
                    break;
            }
        }

        System.out.println(String.format("Car: %.2f", car.getFuelQuantity()));
        System.out.println(String.format("Truck: %.2f", truck.getFuelQuantity()));
    }

    public static void drive(String[] commandInfo) {
        String vehicle = commandInfo[1];
        double distance = Double.parseDouble(commandInfo[2]);
        DecimalFormat df = new DecimalFormat("0.#######");

        switch (vehicle) {
            case "Car":
                if (car.canTravel(distance)) {
                    car.driving(distance);
                    System.out.println(String.format("Car travelled %s km", df.format(distance)));
                } else {
                    System.out.println("Car needs refueling");
                }
                break;
            case "Truck":
                if (truck.canTravel(distance)) {
                    truck.driving(distance);
                    System.out.println(String.format("Truck travelled %s km", df.format(distance)));
                } else {
                    System.out.println("Truck needs refueling");
                }
                break;
        }
    }

    public static void refuel(String[] commandInfo) {
        String vehicle = commandInfo[1];
        double liters = Double.parseDouble(commandInfo[2]);

        switch (vehicle) {
            case "Car":
                car.refueling(liters);
                break;
            case "Truck":
                truck.refueling(liters);
                break;
        }
    }
}
