import java.lang.reflect.Array;
import java.util.ArrayList;

public class Bag extends Packaging {
    ArrayList<Product> products = new ArrayList<>(1);

    public Bag() {
        super("Bag");
        ArrayList<Product> product = new ArrayList<>(1);
    }

    @Override
    public ArrayList<Product> getProductList() {
        return products;
    }

    @Override
    public void AddProduct(Product product) {
        products.add(product);
    }

}
