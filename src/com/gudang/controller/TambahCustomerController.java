package com.gudang.controller;

import com.gudang.model.Customer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TambahCustomerController {

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNama;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtTelepon;

    private CustomerController customerController;

    public void setCustomerController(CustomerController customerController) {
        this.customerController = customerController;
    }

    @FXML
    private void handleTambah() {
        String id = txtId.getText().trim();
        String nama = txtNama.getText().trim();
        String email = txtEmail.getText().trim();
        String telepon = txtTelepon.getText().trim();

        // Validasi field wajib
        if (id.isEmpty() || nama.isEmpty() || email.isEmpty()) {
            showAlert("Mandatory field harus diisi!");
            return;
        }

        // Validasi email
        if (!email.contains("@")) {
            showAlert("Email tidak valid!");
            return;
        }

        // Validasi ID sudah ada
        if (customerController.isIdExists(id)) {
            showAlert("ID customer sudah ada!");
            return;
        }

        // Tambahkan customer ke tabel
        Customer customer = new Customer(id, nama, email, telepon);
        customerController.addCustomer(customer);

        // Tutup popup
        closePopup();
    }

    private void closePopup() {
        Stage stage = (Stage) txtId.getScene().getWindow();
        stage.close();
    }

    private void showAlert(String message) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ErrorDialog.fxml"));
            Scene scene = new Scene(loader.load());

            ErrorDialogController controller = loader.getController();
            controller.setMessage(message);

            Stage stage = new Stage();
            stage.setTitle("Error");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
