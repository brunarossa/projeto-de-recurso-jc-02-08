import java.util.ArrayList;
import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class Warehouse {
    private ArrayList<ArrayList<Position>> matrix;
    private int rowNumber;

    public Warehouse(ArrayList<ArrayList<Position>> matrix) {
        this.matrix = matrix;
        rowNumber = 0;
    }

    public void readFromFile() {
        try {
            File myObj = new File("filename.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                ArrayList<Position> row = new ArrayList<>(data.length());
                for (int i = 0; i < data.length(); i++) {
                    getPositionId(row, data.charAt(i));
                }
                matrix.add(row);
                rowNumber++;

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        ;
    }

    private void getPositionId(ArrayList<Position> row, char c) {
        if (c == 'V') {
            Vehicle vehicle = new Vehicle();
            row.add(vehicle);
            vehicle.setColum(row.indexOf(vehicle));
            vehicle.setRow(rowNumber);
        } else if (c == 'W') {
            row.add(new Wall());
        } else if (c == 'S') {
            row.add(new Shelf());
        } else {
            row.add(new Position());
        }
    }

    private void AddRow(ArrayList<Position> row, int index) {
        matrix.add(index, row);
    }

    public void CreateRows(int HowMany, int colums) {
        for (int i = 0; i < HowMany; i++) {
            ArrayList<Position> row = new ArrayList<>(colums);
            for (int j = 0; j < colums; j++) {
                row.add(new Position());
            }
            AddRow(row, i);
        }
    }

    public void CreateBoard() {
        matrix = new ArrayList<ArrayList<Position>>();
    }

    public void AddPosition(Position position, int row, int colum) {
        matrix.get(row).add(colum, position);
    }

    public ArrayList<ArrayList<Position>> getBoard() {
        return matrix;
    }

    public void printBoard() {
        // PrintColumIndex(matrix.get(0).size());
        for (int i = 0; i < matrix.size(); i++) {
            System.out.println("\n");
            for (int j = 0; j < matrix.get(i).size(); j++) {
                System.out.print("[" + matrix.get(i).get(j).getPositionId() + "]");
            }
        }
    }

    private void PrintColumIndex(int columNumber) {
        for (int i = 0; i < columNumber; i++) {
            System.out.print("[C" + i + "]");
        }
    }

    public boolean AddVehicle(Vehicle vehicle, int row, int colum) {
        if (matrix.get(row).get(colum).getPositionId() == '•') {
            matrix.get(row).remove(colum);
            matrix.get(row).add(colum, vehicle);
            vehicle.setRow(row);
            vehicle.setColum(colum);
            return true;
        } else {
            return false;
        }

    }

    public void RemoveVehicle(Vehicle vehicle, int row, int colum) {
        matrix.get(row).remove(colum);
        matrix.get(row).add(colum, new Position());
    }

}
