package com.liel.views;

import com.gluonhq.charm.glisten.afterburner.GluonPresenter;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import com.liel.MainApp;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class PrimaryPresenter extends GluonPresenter<MainApp> {

    public GridPane GridPaneB;
    @FXML
    private View primary;

    @FXML
    private Label label;

    @FXML
    private ResourceBundle resources;
    
    public void initialize() {
        primary.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = getApp().getAppBar();
                appBar.setStyle("-fx-background-color: #8A2BE2");
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> 
                        getApp().getDrawer().open()));
                appBar.setTitleText("Primary");
                appBar.getActionItems().add(MaterialDesignIcon.SEARCH.button(e -> 
                        System.out.println("Search")));
            }
        });
    }
    
    @FXML
    void buttonClick() {
        label.setText(resources.getString("label.text.2"));
    }

    public void doFillSameB(ActionEvent event) {
    }

    public void doFillRandomlyB(ActionEvent event) {
    }
}
