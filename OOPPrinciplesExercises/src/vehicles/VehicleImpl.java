package vehicles;

public abstract class VehicleImpl implements Vehicle {
    private Double fuelQuantity;
    private Double fuelConsumption;

    protected VehicleImpl(Double fuelQuantity, Double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public void driving(Double km) {
        if (canTravel(km)) {
            this.fuelQuantity -= km * fuelConsumption;
        }
    }

    @Override
    public void refueling(Double quantity) {
        this.fuelQuantity += quantity;
    }

    @Override
    public boolean canTravel(Double km) {
        if (this.fuelQuantity / this.fuelConsumption >= km) {
            return true;
        }

        return false;
    }

    @Override
    public Double getFuelQuantity() {
        return this.fuelQuantity;
    }

    @Override
    public Double getFuelConsumption() {
        return this.fuelConsumption;
    }
}
