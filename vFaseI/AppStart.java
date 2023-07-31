import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AppStart {
    Warehouse board;

    public static void main(String[] args) {
        int number = 0;
        Scanner myObj = new Scanner(System.in);
        Position vehicle = new Vehicle();
        ArrayList<ArrayList<Position>> newBoard = new ArrayList<ArrayList<Position>>();
        ArrayList<Vehicle> inStoreVehicles = new ArrayList<>();
        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Packaging> packagings = new ArrayList<>();
        Warehouse board = new Warehouse(newBoard);
        board.readFromFile();
        board.printBoard();

        while (number != 11) {
            System.out.println("\n\n********** Select Option ***********");
            System.out.println("1: Add Vehicle");
            System.out.println("2: Move Vehicle");
            System.out.println("3: Create Products");
            System.out.println("4: Product List");
            System.out.println("5: Create Package");
            System.out.println("6: Package List");
            System.out.println("7: Add Product to Package");
            System.out.println("8: Add Package to Vehicle");
            System.out.println("9: Deliver");
            System.out.println("10: Add CardBox To Pallet");
            System.out.println("11: Quit");
            number = myObj.nextInt();

            switch (number) {
                case 1:
                    int vehicleOption;
                    int newRow;
                    int newColum;
                    Boolean isGoodLocation;
                    System.out.println("\n********** Wich Vehicle ***********");
                    System.out.println("1: Automatic Guided Card");
                    System.out.println("2: Unit Load Carrier");
                    System.out.println("3: Towing Vehicle");
                    vehicleOption = myObj.nextInt();

                    switch (vehicleOption) {
                        case 1:
                            Vehicle agc = new AutomaticGuidedCard();
                            System.out.println("\nWich Row?");
                            newRow = myObj.nextInt();
                            System.out.println("\nWich Column?");
                            newColum = myObj.nextInt();
                            isGoodLocation = board.AddVehicle(agc, newRow, newColum);
                            if (isGoodLocation == false) {
                                System.out.println("\n!! Illegal Position !!");
                            } else {
                                inStoreVehicles.add(agc);
                                board.printBoard();
                            }

                            break;

                        case 2:
                            Vehicle ulc = new UnitLoadCarrier();
                            System.out.println("\nWich Row?");
                            newRow = myObj.nextInt();
                            System.out.println("\nWich Column?");
                            newColum = myObj.nextInt();
                            isGoodLocation = board.AddVehicle(ulc, newRow, newColum);
                            if (isGoodLocation == false) {
                                System.out.println("\n!! Illegal Position !!");
                            } else {
                                inStoreVehicles.add(ulc);
                                board.printBoard();
                            }
                            break;

                        case 3:
                            TransportCart tc = new TransportCart();
                            Vehicle tv = new TowingVehicle(tc);
                            System.out.println("\nWich Row?");
                            newRow = myObj.nextInt();
                            System.out.println("\nWich Column?");
                            newColum = myObj.nextInt();
                            isGoodLocation = board.AddVehicle(tv, newRow, newColum);
                            if (isGoodLocation == false) {
                                System.out.println("\n!! Illegal Position !!");
                            } else {
                                isGoodLocation = board.AddVehicle(tc, newRow + 1, newColum);
                                if (isGoodLocation == false) {
                                    System.out.println("\n!! Illegal Position !!");
                                    board.RemoveVehicle(tv, newRow, newColum);
                                } else {
                                    inStoreVehicles.add(tv);
                                    board.printBoard();
                                }
                            }

                            break;

                        default:
                            break;
                    }
                    break;

                case 2:
                    int moveOption;
                    int vehicleFromList;
                    Boolean didHeMove;

                    System.out.println("\n********** Wich Direction ***********");
                    System.out.println("1: Move Up");
                    System.out.println("2: Move Down");
                    System.out.println("3: Move Left");
                    System.out.println("4: Move Right");
                    System.out.println("5: Go Back");
                    moveOption = myObj.nextInt();

                    switch (moveOption) {
                        case 1:
                            if (inStoreVehicles.size() > 0) {
                                System.out.println("\nWich Vehicle?");
                                for (int i = 0; i < inStoreVehicles.size(); i++) {
                                    System.out.println(i + ": " + inStoreVehicles.get(i).getName());

                                }
                            } else {
                                System.out.println("\n!! There isn't any vehicles !!");
                                break;
                            }

                            vehicleFromList = myObj.nextInt();

                            inStoreVehicles.get(vehicleFromList).moveUp();
                            didHeMove = board.AddVehicle(
                                    inStoreVehicles.get(vehicleFromList),
                                    inStoreVehicles.get(vehicleFromList).getRow(),
                                    inStoreVehicles.get(vehicleFromList).getColum());
                            if (didHeMove == true) {
                                board.RemoveVehicle(
                                        inStoreVehicles.get(vehicleFromList),
                                        inStoreVehicles.get(vehicleFromList).getRow() + 1,
                                        inStoreVehicles.get(vehicleFromList).getColum());
                                board.printBoard();
                            } else {
                                System.out.println("\n!! Illegal Position !!");
                                board.printBoard();
                            }

                            break;

                        case 2:
                            if (inStoreVehicles.size() > 0) {
                                System.out.println("\nWich Vehicle?");
                                for (int i = 0; i < inStoreVehicles.size(); i++) {
                                    System.out.println(i + ": " + inStoreVehicles.get(i).getName());

                                }
                            } else {
                                System.out.println("\n!! There isn't any vehicles !!");
                                break;
                            }

                            vehicleFromList = myObj.nextInt();

                            inStoreVehicles.get(vehicleFromList).moveDown();
                            didHeMove = board.AddVehicle(
                                    inStoreVehicles.get(vehicleFromList),
                                    inStoreVehicles.get(vehicleFromList).getRow(),
                                    inStoreVehicles.get(vehicleFromList).getColum());
                            if (didHeMove == true) {
                                board.RemoveVehicle(
                                        inStoreVehicles.get(vehicleFromList),
                                        inStoreVehicles.get(vehicleFromList).getRow() - 1,
                                        inStoreVehicles.get(vehicleFromList).getColum());
                                board.printBoard();
                            } else {
                                System.out.println("\n!! Illegal Position !!");
                                board.printBoard();
                            }
                            break;

                        case 3:
                            if (inStoreVehicles.size() > 0) {
                                System.out.println("\nWich Vehicle?");
                                for (int i = 0; i < inStoreVehicles.size(); i++) {
                                    System.out.println(i + ": " + inStoreVehicles.get(i).getName());
                                    System.out.println((i + 1) + ": Go Back");
                                }
                            } else {
                                System.out.println("\n!! There isn't any vehicles !!");
                                break;
                            }

                            vehicleFromList = myObj.nextInt();

                            inStoreVehicles.get(vehicleFromList).moveLeft();
                            didHeMove = board.AddVehicle(
                                    inStoreVehicles.get(vehicleFromList),
                                    inStoreVehicles.get(vehicleFromList).getRow(),
                                    inStoreVehicles.get(vehicleFromList).getColum());
                            if (didHeMove == true) {
                                board.RemoveVehicle(
                                        inStoreVehicles.get(vehicleFromList),
                                        inStoreVehicles.get(vehicleFromList).getRow(),
                                        inStoreVehicles.get(vehicleFromList).getColum() + 1);
                                board.printBoard();
                            } else {
                                System.out.println("\n!! Illegal Position !!");
                                board.printBoard();
                            }
                            break;

                        case 4:
                            if (inStoreVehicles.size() > 0) {
                                System.out.println("\nWich Vehicle?");
                                for (int i = 0; i < inStoreVehicles.size(); i++) {
                                    System.out.println(i + ": " + inStoreVehicles.get(i).getName());

                                }
                            } else {
                                System.out.println("\n!! There isn't any vehicles !!");
                                break;
                            }

                            vehicleFromList = myObj.nextInt();

                            inStoreVehicles.get(vehicleFromList).moveRight();
                            didHeMove = board.AddVehicle(
                                    inStoreVehicles.get(vehicleFromList),
                                    inStoreVehicles.get(vehicleFromList).getRow(),
                                    inStoreVehicles.get(vehicleFromList).getColum());
                            if (didHeMove == true) {
                                board.RemoveVehicle(
                                        inStoreVehicles.get(vehicleFromList),
                                        inStoreVehicles.get(vehicleFromList).getRow(),
                                        inStoreVehicles.get(vehicleFromList).getColum() - 1);
                                board.printBoard();
                            } else {
                                System.out.println("\n!! Illegal Position !!");
                                board.printBoard();
                            }
                            break;

                        case 5:
                            break;

                        default:
                            break;
                    }
                    break;
                case 3:
                    String name;
                    int option;

                    name = myObj.nextLine();

                    System.out.println("\n****** Wich type? ******");
                    System.out.println("1: Book");
                    System.out.println("2: Accessories");
                    System.out.println("3: Small Equipment");
                    System.out.println("4: Large Equipment");
                    System.out.println("5: Large Toy");
                    System.out.println("6: Small Toy");
                    System.out.println("7: Go back");
                    option = myObj.nextInt();

                    switch (option) {
                        case 1:
                            Product newBook = new Book(name);
                            products.add(newBook);
                            break;

                        case 2:
                            Product newAccessories = new Accessories(name);
                            products.add(newAccessories);
                            break;

                        case 3:
                            Product newSmallEquip = new SmallEquip(name);
                            products.add(newSmallEquip);
                            break;

                        case 4:
                            Product newLargeEquip = new LargeEquip(name);
                            products.add(newLargeEquip);
                            break;

                        case 5:
                            Product newLargeToy = new LargeToys(name);
                            products.add(newLargeToy);
                            break;

                        case 6:
                            Product newSmallToy = new SmallToys(name);
                            products.add(newSmallToy);
                            break;

                        case 7:
                            break;

                        default:
                            break;

                    }
                    break;
                case 4:

                    if (products.size() == 0) {
                        System.out.println("\nList is Empty");
                        break;
                    }
                    for (int i = 0; i < products.size(); i++) {
                        System.out.println((i) + ": " + products.get(i).getType());
                    }

                    break;

                case 5:
                    int option2;

                    System.out.println("\n****** Wich type? ******");
                    System.out.println("1: Box");
                    System.out.println("2: Card Box");
                    System.out.println("3: Bag");
                    System.out.println("4: Pallet");
                    System.out.println("5: Go back");
                    option2 = myObj.nextInt();

                    switch (option2) {
                        case 1:
                            Packaging newBox = new Box();
                            packagings.add(newBox);
                            break;

                        case 2:
                            Packaging newCardBox = new CardBox();
                            packagings.add(newCardBox);
                            break;

                        case 3:
                            Packaging newBag = new Bag();
                            packagings.add(newBag);
                            break;

                        case 4:
                            Packaging newPallet = new Pallet();
                            packagings.add(newPallet);
                            break;

                        case 5:
                            break;
                        default:
                            break;
                    }
                case 6:

                    if (packagings.size() == 0) {
                        System.out.println("\n!! List is Empty !!");
                        break;
                    }
                    for (int i = 0; i < packagings.size(); i++) {
                        System.out.println((i) + ": " + packagings.get(i).getType());
                    }
                    break;

                case 7:
                    int productIndex;
                    int packagingIndex;

                    if (packagings.isEmpty() || products.isEmpty()) {
                        System.out.println("\n!! Package List or Product List is empty !!");
                        break;
                    }

                    System.out.println("\nSelect Product");
                    for (int i = 0; i < products.size(); i++) {
                        System.out.println((i) + ": " + products.get(i).getType());
                    }
                    productIndex = myObj.nextInt();

                    System.out.println("\nSelect Packaging");
                    for (int i = 0; i < packagings.size(); i++) {
                        System.out.println((i) + ": " + packagings.get(i).getType());
                    }
                    packagingIndex = myObj.nextInt();

                    packagings.get(packagingIndex).AddProduct(products.get(productIndex));

                    System.out.println("\nProduct " + products.get(productIndex).getType() + " added to "
                            + packagings.get(packagingIndex).getType());
                    break;

                case 8:
                    int vehicleIndex;
                    int packagingToVehicleIndex;
                    System.out.println("\nSelect Vehicle");
                    vehicleIndex = myObj.nextInt();

                    System.out.println("\nSelect Packging");
                    packagingToVehicleIndex = myObj.nextInt();

                    if (packagings.get(packagingToVehicleIndex).getType().equals("Pallet")
                            && inStoreVehicles.get(vehicleIndex).getName().compareTo("Unit Load Carrier") != 0) {
                        System.out.println("\n!! Cant add this package !!");
                        break;
                    } else {
                        inStoreVehicles.get(vehicleIndex).AddPackage(packagings.get(packagingToVehicleIndex));
                        System.out
                                .println("\nPackage " + packagings.get(packagingToVehicleIndex).getType() + " added to "
                                + inStoreVehicles.get(vehicleIndex).getName());
                        break;
                    }

                case 9:
                    int vehicleFromListToDeliver;

                    if (inStoreVehicles.size() > 0) {
                        System.out.println("\nWich Vehicle?");
                        for (int i = 0; i < inStoreVehicles.size(); i++) {
                            System.out.println(i + ": " + inStoreVehicles.get(i).getName());
                        }
                    } else {
                        System.out.println("\n!! There isn't any vehicles !!");
                        break;
                    }
                    vehicleFromListToDeliver = myObj.nextInt();

                    int row;
                    int colum;

                    row = inStoreVehicles.get(vehicleFromListToDeliver).getRow();
                    colum = inStoreVehicles.get(vehicleFromListToDeliver).getColum();

                    if (newBoard.get(row).get(colum + 1).getPositionId() == 'S') {
                        newBoard.get(row).get(colum + 1)
                                .addAllProducts(inStoreVehicles.get(vehicleFromListToDeliver).getProducts());
                        System.out.println("\nProduct added to the Shelf");
                        break;
                    } else if (newBoard.get(row).get(colum - 1).getPositionId() == 'S') {
                        newBoard.get(row).get(colum - 1)
                                .addAllProducts(inStoreVehicles.get(vehicleFromListToDeliver).getProducts());
                        System.out.println("\nProduct added to the Shelf");
                        break;
                    } else if (newBoard.get(row + 1).get(colum).getPositionId() == 'S') {
                        newBoard.get(row + 1).get(colum)
                                .addAllProducts(inStoreVehicles.get(vehicleFromListToDeliver).getProducts());
                        System.out.println("\nProduct added to the Shelf");
                        break;

                    } else if (newBoard.get(row - 1).get(colum).getPositionId() == 'S') {
                        newBoard.get(row - 1).get(colum)
                                .addAllProducts(inStoreVehicles.get(vehicleFromListToDeliver).getProducts());
                        System.out.println("\nProduct added to the Shelf");
                        break;
                    } else {
                        System.out.println("\nNo Shelf nearby");
                        break;
                    }

            }
        }

    }
}
