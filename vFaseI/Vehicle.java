import java.util.ArrayList;
import java.util.Collections;

public class Vehicle extends Position {
    private Path newPath;
    private String name;
    private Packaging pack;

    public Vehicle() {
        super(2, 2, 'V');
        name = "";
        pack = null;
    }

    public String getName() {
        return name;
    }

    public void AddNewPath() {
        newPath = new Path();
    }

    public void moveDown() {
        this.setRow(getRow() + 1);
    }

    public void moveUp() {
        this.setRow(getRow() - 1);
    }

    public void moveRight() {
        this.setColum(getColum() + 1);
    }

    public void moveLeft() {
        this.setColum(getColum() - 1);
    }

    public void AddPackage(Packaging pack) {

    }

    public Packaging pack() {
        return pack;
    }

}
