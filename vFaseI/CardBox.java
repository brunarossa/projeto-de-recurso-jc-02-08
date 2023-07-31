import java.util.ArrayList;

public class CardBox extends Packaging {

    ArrayList<Product> smallProducts = new ArrayList<>();
    private static int productNumber;

    public CardBox() {
        super("CardBox");
        ArrayList<Product> smallProducts = new ArrayList<>();
    }

    @Override
    public ArrayList<Product> getProductList() {
        return smallProducts;
    }

    @Override
    public void AddProduct(Product product) {
        if (productNumber < 10 && product.getWeight() < 10) {
            smallProducts.add(productNumber, product);
            productNumber++;
        } else {
            System.out.println("\n!! Box is Full !!");
        }

    }

}
