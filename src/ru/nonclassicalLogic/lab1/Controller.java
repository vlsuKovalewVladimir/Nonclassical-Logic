package ru.nonclassicalLogic.lab1;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class Controller {

    public Button btn;

    public void click(ActionEvent actionEvent) {
        btn.setText("test");
    }
}
