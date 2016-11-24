package fr.flegac.experiments.tiling;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TilingViewer2 extends Application {

    public static void main(final String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage primaryStage) {

        // construct gridpane
        final GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(0, 10, 0, 10));

        grid.add(new Label(" "), 1, 1);
        grid.add(new Button("X"), 2, 2);
        grid.add(new Button("X"), 0, 0);

        final Scene scene = new Scene(grid, 500, 500);

        primaryStage.setScene(scene);
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.setTitle("Tiling viewer");
        primaryStage.show();

    }

}
