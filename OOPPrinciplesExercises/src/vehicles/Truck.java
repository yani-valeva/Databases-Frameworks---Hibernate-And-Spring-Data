package vehicles;

public class Truck extends VehicleImpl {
    public Truck(Double fuelQuantity, Double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + 1.6);
    }

    @Override
    public void refueling(Double quantity) {
        super.refueling(quantity * 0.95);
    }
}
