package com.example.lab05_zpo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

import java.security.Key;

public class VInputText {
    @FXML
    private Button confirmButton;

    @FXML
    private Button imageButton;

    @FXML
    @MyPattern(regex = "1", message = "Zła liczba !")
    public TextField textField;
    private static TextField staticTextField;

    private MyPatternValidator myPatternValidator;

    @FXML
    void initialize() {
        VInputText.staticTextField = this.textField;
        initializeValidator();
        textField.addEventFilter(KeyEvent.KEY_RELEASED, typing());
    }

    private EventHandler<KeyEvent> typing() {            //autocheck
        return keyEvent -> {
            myPatternValidator.validate(staticTextField.getText());
            if (myPatternValidator.isValid())
            {
                imageButton.setGraphic(new ImageView(new Image("file:zielone.png")));
                imageButton.setOpacity(100);
                Tooltip tooltip = new Tooltip("");
                imageButton.setTooltip(tooltip);
                confirmButton.setDisable(false);
            } else {
                imageButton.setGraphic(new ImageView(new Image("file:czerwone.png")));
                imageButton.setOpacity(100);
                Tooltip tooltip1 = new Tooltip(myPatternValidator.getMessage());
                imageButton.setTooltip(tooltip1);
                confirmButton.setDisable(true);

            }
        };
    }

    private void initializeValidator() {
        myPatternValidator = new MyPatternValidator(this);
    }

    @FXML
    void usedButton(ActionEvent event) {
        System.out.println(myPatternValidator.isValid());
    }
}