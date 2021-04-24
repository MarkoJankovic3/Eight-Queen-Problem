package marko.jankovic;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class GUI extends StackPane {

    private GraphicsContext graphicsContext;
    private GraphicsContext borders;
    private double size = 500;
    private double singleSize;
    public Label label;
    public Button back;
    public Button next;

    private int numQueens = 8;
    private Image queen = new Image("queen.png");

    public GUI() {
        Canvas canvas = new Canvas(size, size);
        Canvas backCanvas = new Canvas(size, size);
        graphicsContext = canvas.getGraphicsContext2D();
        borders = backCanvas.getGraphicsContext2D();
        VBox box = new VBox();
        label = new Label("1/92");
        //Buttons
        HBox buttons = new HBox();
        back = new Button("<<");
        next = new Button(">>");
        buttons.getChildren().addAll(back, next);
        buttons.setAlignment(Pos.TOP_CENTER);
        box.getChildren().addAll(label, buttons);
        box.setPadding(new Insets(10));
        box.setSpacing(10);
        box.setAlignment(Pos.TOP_CENTER);



        clearTiles();
        singleSize = size / numQueens;
        drawGrid();
        this.setBackground(new Background(new BackgroundFill(Color.ANTIQUEWHITE, CornerRadii.EMPTY, new Insets(0, 0, 0, 0))));
        this.setPrefWidth(size);
        this.setPrefHeight(size);
        this.getChildren().addAll(canvas, backCanvas, box);
        for (int i = 0; i < numQueens; i++) {
            for (int j = 0; j < numQueens; j++) {
                if ((i + j) % 2 == 1) {
                    drawDarkCell(i, j);
                }
            }
        }
    }

    public void drawQueens(int[] board) {
        clearTiles();
        borders.clearRect(0, 0, size, size);
        numQueens = board != null ? board.length : numQueens;
        singleSize = size / numQueens;
        drawGrid();
        for (int i = 0; i < numQueens; i++) {
            for (int j = 0; j < numQueens; j++) {
                if ((i + j) % 2 == 1) {
                    drawDarkCell(i, j);
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            addQueen(i, board[i]);
        }
    }

    private void addQueen(int i, int j) {
        graphicsContext.drawImage(queen, singleSize*(i + 0.1), singleSize*(j + 0.1), singleSize*.8, singleSize*.8);
    }

    public void clearTiles() {
        graphicsContext.clearRect(0, 0, size, size);
    }

    private void drawDarkCell(int i, int j) {
        graphicsContext.setFill(Color.DARKOLIVEGREEN);
        graphicsContext.fillRect(i*singleSize, j*singleSize, singleSize, singleSize);
    }

    private void drawGrid() {
        for (int i = 0; i <= numQueens; i++) {
            borders.setLineWidth(i == 0 || i == numQueens ? 2.4 : 0.6);
            borders.setStroke(Color.DIMGRAY);
            borders.strokeLine(0, i * singleSize, size, i * singleSize);
            borders.strokeLine(i * singleSize, 0, i * singleSize, size);
        }
    }
}
