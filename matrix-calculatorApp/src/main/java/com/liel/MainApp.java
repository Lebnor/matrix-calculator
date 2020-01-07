package com.liel;

import com.gluonhq.charm.down.Platform;
import com.gluonhq.charm.down.Services;
import com.gluonhq.charm.down.plugins.DisplayService;
import com.liel.views.AppViewManager;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.visual.Swatch;
import javafx.geometry.Dimension2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainApp extends MobileApplication {

    @Override
    public void init() {
        AppViewManager.registerViewsAndDrawer(this);
    }

    @Override
    public void postInit(Scene scene) {
        Swatch.BLUE.assignTo(scene);

        scene.getStylesheets().add(MainApp.class.getResource("style.css").toExternalForm());
        if (Platform.isDesktop()) {
            scene.getWindow().setWidth(500);
            scene.getWindow().setHeight(700);
        }
        ((Stage) scene.getWindow()).getIcons().add(new Image(MainApp.class.getResourceAsStream("/icon.png")));
        System.out.println(">> Inside postInit");

    }
}
