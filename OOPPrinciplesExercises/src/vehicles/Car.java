package vehicles;

public class Car extends VehicleImpl {
    public Car(Double fuelQuantity, Double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + 0.9);
    }
}
