import java.util.ArrayList;

public class TransportCart extends Vehicle implements UnLoadable {
    private int weight;
    private ArrayList<Package> packs;
    private String name;

    public TransportCart() {
        super();
        name = "Transport Cart";
    }

    public void addProduct(Package pack) {
        if (weight < 200) {
            packs.add(pack);
            // weight += product.getWeight();
        } else {
            System.out.println("Full");
        }
    }

    @Override
    public ArrayList<Product> getProducts() {
        return new ArrayList<Product>();
    }
}
