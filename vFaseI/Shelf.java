import java.util.ArrayList;

public class Shelf extends Position {
    private ArrayList<Product> products = new ArrayList<>(10);

    public Shelf() {
        super('S');
        ArrayList<Product> products = new ArrayList<>(10);
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public ArrayList<Product> getProducts() {
        return products;
    }

    @Override
    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    @Override
    public void loadProducts(UnLoadable unLoadable) {
        products.addAll(0, unLoadable.getProducts());
    }

    @Override
    public void addAllProducts(ArrayList<Product> newProducts) {
        products.addAll(0, newProducts);
    }
}
