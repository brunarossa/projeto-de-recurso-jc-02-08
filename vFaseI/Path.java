import java.util.ArrayList;

public class Path {

    private ArrayList<Position> newPath;

    public Path() {
        ArrayList<Position> newPath = new ArrayList<>();
    }

    public void addPosition(Position newPosition) {
        newPath.add(newPosition);
    }

}
