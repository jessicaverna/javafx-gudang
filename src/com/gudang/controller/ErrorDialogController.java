package com.gudang.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ErrorDialogController {

    @FXML
    private Label lblMessage;

    public void setMessage(String message) {
        lblMessage.setText(message);
    }

    @FXML
    private void handleOk() {
        Stage stage = (Stage) lblMessage.getScene().getWindow();
        stage.close();
    }
}
