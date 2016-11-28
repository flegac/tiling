package fr.flegac.experiments.tiling;

import fr.flegac.experiments.tiling.solver.SmartTilingSolver;
import fr.flegac.experiments.tiling.solver.TilingSolver;
import fr.flegac.experiments.tiling.tiling.Tiling;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TilingViewer extends Application {

    public static void main(final String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage primaryStage) {

        // construct tiling
        final TilingSolver solver = new SmartTilingSolver(12, 12);
        final Tiling tiling = solver.solve(10000);

        // construct gridpane
        final GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(0, 10, 0, 10));

        for (int x = 0; x < tiling.getWidth(); x++) {
            for (int y = 0; y < tiling.getHeight(); y++) {
                if (tiling.getTile(tiling.cellId(x, y)) != null) {
                    grid.add(new Button("X"), x + 1, y + 1);
                }
                else {
                    grid.add(new Label(" "), x + 1, y + 1);
                }
            }
        }
        for (int x = 0; x < tiling.getWidth(); x++) {
            grid.add(new Label("" + x), x + 1, 0);
        }
        for (int y = 0; y < tiling.getHeight(); y++) {
            grid.add(new Label("" + y), 0, y + 1);
        }

        final Scene scene = new Scene(grid, 500, 500);

        primaryStage.setScene(scene);
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.setTitle("Tiling viewer");
        primaryStage.show();

    }

}
