package com.gudang.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ConfirmDialogController {

    @FXML
    private Label lblMessage;

    private boolean confirmed = false;

    public void setMessage(String message) {
        lblMessage.setText(message);
    }

    @FXML
    private void handleYa() {
        confirmed = true;
        closeDialog();
    }

    @FXML
    private void handleTidak() {
        confirmed = false;
        closeDialog();
    }

    private void closeDialog() {
        Stage stage = (Stage) lblMessage.getScene().getWindow();
        stage.close();
    }

    public boolean isConfirmed() {
        return confirmed;
    }
}
