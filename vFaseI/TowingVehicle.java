
public class TowingVehicle extends Vehicle {
    private TransportCart transportCart;
    String name;

    public TowingVehicle(TransportCart transportCart) {
        super();
        this.transportCart = transportCart;
        name = "Towing Vehicle";
    }

    @Override
    public String getName() {
        return name;
    }
}
