package com.example;
package vFaseI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.util.ArrayList;

public class WarehouseSimulationApp extends Application {
    private static final int GRID_SIZE = 10;
    private static final int CELL_SIZE = 50;

    private Warehouse warehouse;
    private Rectangle[][] grid;

    @Override
    public void start(Stage primaryStage) {
        warehouse = new Warehouse(new ArrayList<>());
        warehouse.CreateBoard();
        warehouse.CreateRows(GRID_SIZE, GRID_SIZE);
        grid = new Rectangle[GRID_SIZE][GRID_SIZE];

        GridPane root = new GridPane();

        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                Rectangle cell = new Rectangle(CELL_SIZE, CELL_SIZE);
                cell.setFill(Color.WHITE);
                cell.setStroke(Color.BLACK);
                grid[row][col] = cell;
                root.add(cell, col, row);
            }
        }
        initializeWarehouse();

        Scene scene = new Scene(root, GRID_SIZE * CELL_SIZE, GRID_SIZE * CELL_SIZE);
        primaryStage.setTitle("Warehouse Simulation");
        primaryStage.setScene(scene);
        primaryStage.show();
        root.requestFocus();

        Thread simulationThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                updateSimulation();
            }
        });
        simulationThread.setDaemon(true);
        simulationThread.start();
    }

    private void initializeWarehouse() {
        ArrayList<ArrayList<Position>> board = warehouse.getBoard();
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                Position position = board.get(row).get(col);
                if (position instanceof Vehicle) {
                    grid[row][col].setFill(Color.BLUE);
                } else if (position instanceof Shelf) {
                    grid[row][col].setFill(Color.GRAY);
                } else if (position instanceof Wall) {
                    grid[row][col].setFill(Color.BLACK);
                }
            }
        }
    }

    private void updateSimulation() {
        ArrayList<Vehicle> vehicles = getAllVehicles();
        for (Vehicle vehicle : vehicles) {
            Position currentPosition = warehouse.getPosition(vehicle.getRow(), vehicle.getColum());
            grid[vehicle.getRow()][vehicle.getColum()].setFill(Color.WHITE);
            moveVehicle(vehicle);
            currentPosition.leave(vehicle);
            Position newPosition = warehouse.getPosition(vehicle.getRow(), vehicle.getColum());
            newPosition.enter(vehicle);
            grid[vehicle.getRow()][vehicle.getColum()].setFill(Color.BLUE);
        }
        updateUI();
    }

    private void moveVehicle(Vehicle vehicle) {
        int randomDirection = (int) (Math.random() * 4);
        switch (randomDirection) {
            case 0:
                vehicle.moveUp();
                break;
            case 1:
                vehicle.moveDown();
                break;
            case 2:
                vehicle.moveLeft();
                break;
            case 3:
                vehicle.moveRight();
                break;
        }
    }

    private ArrayList<Vehicle> getAllVehicles() {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        ArrayList<ArrayList<Position>> board = warehouse.getBoard();
        for (ArrayList<Position> row : board) {
            for (Position position : row) {
                if (position instanceof Vehicle) {
                    vehicles.add((Vehicle) position);
                }
            }
        }
        return vehicles;
    }

    private void updateUI() {
        ArrayList<ArrayList<Position>> board = warehouse.getBoard();
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                Position position = board.get(row).get(col);
                if (position instanceof Vehicle) {
                    grid[row][col].setFill(Color.BLUE);
                } else if (position instanceof Shelf) {
                    grid[row][col].setFill(Color.GRAY);
                } else if (position instanceof Wall) {
                    grid[row][col].setFill(Color.BLACK);
                } else {
                    grid[row][col].setFill(Color.WHITE);
                }
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}