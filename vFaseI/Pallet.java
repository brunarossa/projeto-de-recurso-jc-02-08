import java.util.ArrayList;

public class Pallet extends Packaging {

    private static int numberOfCardBoxs = 0;
    private ArrayList<CardBox> cardBoxList = new ArrayList<>();;

    public Pallet() {
        super("Pallet");
        this.cardBoxList = new ArrayList<>();
    }

    public void addCardBox(CardBox cardBox) {
        this.cardBoxList.add(numberOfCardBoxs, cardBox);
        numberOfCardBoxs++;
    }

    @Override
    public ArrayList<Product> getProductList() {
        ArrayList<Product> products = new ArrayList<>();
        for (int i = 0; i < cardBoxList.size(); i++) {
            products.addAll(0, cardBoxList.get(i).getProductList());
        }

        return products;
    }

}
