package com.liel.matrix_visuals;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public abstract class MatrixFactory {

//    public static void paintMatrix(boolean editable, int[][] data, GridPane gridPane) {
//        if (editable) {
//
//        } else {
////            paintMatrix(data, gridPane);
//        }
//    }

    public static void repopulate(GridPane pane, int[][] data){
        pane.getChildren().clear();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                TextField textField = new TextField(data[i][j] + "");
                textField.setAlignment(Pos.CENTER);
//                label.setStyle("-fx-text-fill: black; -fx-font-family: 'Comic Sans MS';-fx-font-size: 16px;-fx-border-width: 1px;-fx-border-color: black;");

                System.out.println(pane.getWidth());
                System.out.println(pane.getHeight());
//                label.setMaxHeight(70);
//                label.setMaxWidth(70);
//                label.setPrefHeight(70);
//                label.setPrefWidth(70);
//                label.setMinHeight(70);
//                label.setMinWidth(70);
                pane.add(textField, i, j);
                GridPane.setFillHeight(textField, true);
                GridPane.setFillWidth(textField, true);
            }
        }
    }

    public static GridPane createMatrix(int[][] data) {
        GridPane pane = new GridPane();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                Label label = new Label(data[i][j] + "");
                label.setAlignment(Pos.CENTER);
                label.setStyle("-fx-text-fill: black; -fx-font-family: 'Comic Sans MS';-fx-font-size: 16px;-fx-border-width: 1px;-fx-border-color: black;");

                System.out.println(">> inside createMatrix\n");
                System.out.println("Row Constraints " + pane.getRowConstraints());
                System.out.println("Column Constraints " + pane.getColumnConstraints());
                System.out.println(pane.getWidth());
                System.out.println(pane.getHeight());
                label.setMaxHeight(70);
                label.setMaxWidth(70);
                label.setPrefHeight(70);
                label.setPrefWidth(70);
                label.setMinHeight(70);
                label.setMinWidth(70);
                label.setWrapText(false);
                pane.add(label, i, j);
                GridPane.setFillHeight(label, true);
                GridPane.setFillWidth(label, true);
            }
        }
        return pane;
    }

}
