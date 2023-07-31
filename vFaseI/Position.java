import java.util.ArrayList;

public class Position implements ShelfInterface {

    private int colum;
    private int row;
    private char PositionId;

    public Position(int colum, int row, char PositionId) {
        this.colum = colum;
        this.row = row;
        this.PositionId = PositionId;
    }

    public Position() {
        PositionId = '•';
    }

    public Position(char PositionId) {
        colum = 0;
        row = 0;
        this.PositionId = PositionId;
    }

    public int getColum() {
        return colum;
    }

    public int getRow() {
        return row;
    }

    public void setColum(int colum) {
        this.colum = colum;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public char getPositionId() {
        return PositionId;
    }

    public void addProduct(Product product) {
    }

    public ArrayList<Product> getProducts() {
        return null;
    }

    public void setProducts(ArrayList<Product> products) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setProducts'");
    }

    public void loadProducts(UnLoadable unLoadable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loadProducts'");
    }

    @Override
    public void addAllProducts(ArrayList<Product> newProducts) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAllProducts'");
    }

}
