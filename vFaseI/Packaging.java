import java.util.ArrayList;

public class Packaging {
    private String type;
    private static int id = 0;
    String name;

    public Packaging(String type) {
        id++;
        this.type = type;
        name = type + id;
    }

    public String getName() {
        return name;
    }

    public void AddProduct(Product product) {

    }

    public String getType() {
        return type;
    }

    public Product getProduct() {
        return null;
    }

    public ArrayList<Product> getProductList() {
        return null;
    }

}
