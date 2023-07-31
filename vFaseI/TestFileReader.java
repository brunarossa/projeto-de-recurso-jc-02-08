import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class TestFileReader {
  private int howManyRows;
  private int howManyColums;
  int currentNumber;

  public TestFileReader() {

  }

  public void lol() {
    howManyColums = 1;

    try {
      File myObj = new File("filename.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        int currentNumber = 1;
        String data = myReader.nextLine();
        howManyRows++;

        System.out.println(data);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}
