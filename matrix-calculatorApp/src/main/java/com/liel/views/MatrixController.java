package com.liel.views;

import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import com.liel.MatrixMultiplicationUtility;
import com.liel.matrix_visuals.MatrixFactory;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.Iterator;
import java.util.Random;

public class MatrixController {
    @FXML
    private Label equationDescription;
    @FXML
    private VBox solutionPanelLocation;
    @FXML
    private VBox bottomPanel;
    @FXML
    private TextField label0;
    @FXML
    private View primary;

    @FXML
    private Button calculateButton;
    @FXML
    private Button fillSameA;
    @FXML
    private Button fillRandomlyA;
    @FXML
    private GridPane gridPaneA;
    @FXML
    private Random random;
    @FXML
    private Button FillRandomlyB;
    @FXML
    private Button FillSameB;
    @FXML
    private GridPane gridPaneB;


    private GridPane solutionPane;

    public void initialize() {
        for (Node node : gridPaneA.getChildren()) {
            if (node instanceof TextField) {
                ((TextField) node).setAlignment(Pos.CENTER);
            }
        }
        for (Node node : gridPaneB.getChildren()) {
            if (node instanceof TextField) {
                ((TextField) node).setAlignment(Pos.CENTER);
            }
        }
        label0.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println(">> inside changed method");
                if (!newValue.matches("\\d")) {
                    label0.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        System.out.println(">> inside MatrixController initialize()");
        this.random = new Random();

        primary.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = MobileApplication.getInstance().getAppBar();
                appBar.setStyle("-fx-background-color: #191970");
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e ->
                        MobileApplication.getInstance().getDrawer().open()));
                appBar.setTitleText("Primary");
                appBar.getActionItems().add(MaterialDesignIcon.SEARCH.button(e ->
                        System.out.println("Search")));
            }
        });

    }

    public void fillSame(ActionEvent event) {
        if (event.getSource() == fillSameA) {
            fillSame(gridPaneA);
        } else if (event.getSource() == FillSameB) {
            fillSame(gridPaneB);
        }
    }

    private void fillSame(GridPane gridPane) {
        // todo prompt user for the number to fill
        int numberToFill = random.nextInt(99);
        //
        for (Node node : gridPane.getChildren()) {
            if (node instanceof TextField) {
                System.out.println(((TextField) node).getText());
                ((TextField) node).setText(numberToFill + "");
            }
        }
    }


    public void fillRandomly(ActionEvent event) {
        if (event.getSource() == fillRandomlyA) {
            fillRandomly(gridPaneA);
        } else if (event.getSource() == FillRandomlyB) {
            fillRandomly(gridPaneB);
        }
    }

    private void fillRandomly(GridPane gridPane) {
        for (Node node : gridPane.getChildren()) {
            if (node instanceof TextField) {
                ((TextField) node).setText(random.nextInt(99) + "");
            }
        }
    }

    public void performCalculation(ActionEvent event) {
        long start = System.currentTimeMillis();


        int[][] a = getMatrixFromGridPane(gridPaneA);
        int[][] b = getMatrixFromGridPane(gridPaneB);


        int[][] c = MatrixMultiplicationUtility.matrixMultiplication(a, b);

        solutionPanelLocation.getChildren().clear();
        GridPane solutionPane = MatrixFactory.createMatrix(c);
        solutionPanelLocation.getChildren().add(solutionPane);

        MatrixMultiplicationUtility.printMatrix(a);
        System.out.println();
        MatrixMultiplicationUtility.printMatrix(b);

        equationDescription.setVisible(true);


        long end = System.currentTimeMillis();
        System.out.println("Total time taken: " + (end - start));

    }

    private int[][] getMatrixFromGridPane(GridPane gridPane) {
        int length = gridPane.getColumnConstraints().size();
        int[][] a = new int[length][length];
        Iterator<Node> iterator = gridPane.getChildren().iterator();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                Node node = iterator.next();
                if (node instanceof TextField) {
                    String value = ((TextField) node).getText();

                    if (value == null || value.isEmpty()) {
                        continue;
                    }
                    int num = Integer.parseInt(value);
                    a[i][j] = num;
                }
            }
        }
        return a;
    }
}
