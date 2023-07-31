import java.util.ArrayList;

public interface ShelfInterface {

    public void addProduct(Product product);

    public ArrayList<Product> getProducts();

    public void setProducts(ArrayList<Product> products);

    public void loadProducts(UnLoadable unLoadable);

    public void addAllProducts(ArrayList<Product> newProducts);
}
