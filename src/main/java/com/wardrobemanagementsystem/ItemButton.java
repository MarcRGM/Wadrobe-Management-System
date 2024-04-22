package com.wardrobemanagementsystem;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class ItemButton {
    private Button button;
    private String name;

    ItemButton(ImageView imageView, String name) {
        this.button = new Button();
        this.name = name;

        button.setMinWidth(170);
        button.setMaxWidth(170);
        button.setPrefWidth(170);
        button.setMinHeight(170);
        button.setMaxHeight(170);
        button.setPrefHeight(170);

        imageView.setFitWidth(150);
        imageView.setFitHeight(150);

        button.setGraphic(imageView);

    }

    public Button getButton() {
        return this.button;
    }

    public String getName() {
        return this.name;
    }

}


