package com.gudang.controller;

import com.gudang.model.Customer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EditCustomerController {

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNama;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtTelepon;

    private Customer customer;
    private CustomerController customerController;

    public void setCustomer(Customer customer) {
        this.customer = customer;
        txtId.setText(customer.getId());
        txtNama.setText(customer.getNama());
        txtEmail.setText(customer.getEmail());
        txtTelepon.setText(customer.getTelepon());
    }

    public void setCustomerController(CustomerController customerController) {
        this.customerController = customerController;
    }

    @FXML
    private void handleUpdate() {
        String nama = txtNama.getText().trim();
        String email = txtEmail.getText().trim();
        String telepon = txtTelepon.getText().trim();

        // Validasi field wajib
        if (nama.isEmpty() || email.isEmpty()) {
            showAlert("Mandatory field harus diisi!");
            return;
        }

        // Validasi email
        if (!email.contains("@")) {
            showAlert("Email tidak valid!");
            return;
        }

        // Update data customer
        customer.setNama(nama);
        customer.setEmail(email);
        customer.setTelepon(telepon);

        // Refresh tabel
        customerController.refreshTable();

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
