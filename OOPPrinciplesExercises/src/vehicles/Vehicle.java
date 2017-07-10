package vehicles;

public interface Vehicle {
    void driving(Double km);
    void refueling(Double quantity);
    boolean canTravel(Double km);
    Double getFuelQuantity();
    Double getFuelConsumption();
}
