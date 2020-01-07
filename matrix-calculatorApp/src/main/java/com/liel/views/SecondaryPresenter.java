package com.liel.views;

import com.gluonhq.charm.glisten.afterburner.GluonPresenter;
import com.gluonhq.charm.glisten.animation.BounceInRightTransition;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.FloatingActionButton;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import com.liel.MainApp;
import javafx.fxml.FXML;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class SecondaryPresenter extends GluonPresenter<MainApp> {

    @FXML
    private WebView webView;
    @FXML
    private View secondary;

    public void initialize() {

        secondary.setShowTransitionFactory(BounceInRightTransition::new);

        FloatingActionButton fab = new FloatingActionButton(MaterialDesignIcon.INFO.text,
                e -> System.out.println("Info"));
        fab.showOn(secondary);

        WebEngine webEngine = webView.getEngine();
        webEngine.loadContent("Hello World", "text/html");
        webEngine.load("https://en.wikipedia.org/wiki/Matrix_multiplication");


        secondary.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = getApp().getAppBar();

                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e ->
                        getApp().getDrawer().open()));
                appBar.setTitleText("Secondary");
                appBar.getActionItems().add(MaterialDesignIcon.FAVORITE.button(e ->
                        System.out.println("Favorite")));
            }
        });
    }
}
