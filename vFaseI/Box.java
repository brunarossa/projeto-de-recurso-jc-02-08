import java.util.ArrayList;

public class Box extends Packaging {
    ArrayList<Product> products = new ArrayList<>(1);

    public Box() {
        super("Box");
        ArrayList<Product> products = new ArrayList<>(1);
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
