package com.wardrobemanagementsystem;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class ItemButton {
    private Button button;
    private String name;

    ItemButton(ImageView imageView, String name) {
        this.button = new Button();
        this.name = name;

        button.setMinWidth(150);
        button.setMaxWidth(150);
        button.setPrefWidth(150);
        button.setMinHeight(150);
        button.setMaxHeight(150);
        button.setPrefHeight(150);

        imageView.setFitWidth(125);
        imageView.setFitHeight(125);

        button.setGraphic(imageView);

    }

    public Button getButton() {
        return this.button;
    }

    public String getName() {
        return this.name;
    }

}


