import java.util.ArrayList;

public class UnitLoadCarrier extends Vehicle implements UnLoadable {
    private Packaging pallet;
    private String name;

    public UnitLoadCarrier() {
        super();
        pallet = new Pallet();
        name = "Unit Load Carrier";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void AddPackage(Packaging pack) {
        this.pallet = pack;
    }

    @Override
    public ArrayList<Product> getProducts() {
        return new ArrayList<Product>();
    }

}
