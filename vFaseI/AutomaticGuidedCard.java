import java.util.ArrayList;
import java.util.List;

public class AutomaticGuidedCard extends Vehicle implements UnLoadable {
    private List<Packaging> packs = new ArrayList<>();
    private int weight;
    private String name;
    int row;
    int colum;
    char PositionId;

    public AutomaticGuidedCard() {
        super();
        List<Packaging> packs = new ArrayList<>();
        weight = 0;
        name = "Automatic Guided Card";
    }

    @Override
    public void AddPackage(Packaging pack) {
        if (weight < 100) {
            packs.add(pack);
            // weight += product.getWeight();
        } else {
            System.out.println("Full");
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ArrayList<Product> getProducts() {
        ArrayList<Product> products = new ArrayList<>();
        for (int i = 0; i < packs.size(); i++) {
            products.addAll(0, packs.get(i).getProductList());
        }
        return products;
    }
}
