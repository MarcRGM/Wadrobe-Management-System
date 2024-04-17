package com.wardrobemanagementsystem;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class WardrobeController {

    @FXML
    private Pane paneShirtInfo, paneDressInfo;

    @FXML
    protected void btnShirt() {
        paneShirtInfo.setVisible(true);
        paneDressInfo.setVisible(false);
    }

    @FXML
    protected void btnDress() {
        paneDressInfo.setVisible(true);
        paneShirtInfo.setVisible(false);
    }

    @FXML
    protected void btnCloseInfo() {
        paneShirtInfo.setVisible(false);
        paneDressInfo.setVisible(false);
    }

}
