package com.gudang.controller;

import com.gudang.model.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CustomerController {

    @FXML
    private TableView<Customer> tableCustomer;

    @FXML
    private TableColumn<Customer, String> colId;

    @FXML
    private TableColumn<Customer, String> colNama;

    @FXML
    private TableColumn<Customer, String> colEmail;

    @FXML
    private TableColumn<Customer, String> colTelepon;

    private ObservableList<Customer> customerList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Set cell value factory untuk setiap kolom
        colId.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        colNama.setCellValueFactory(cellData -> cellData.getValue().namaProperty());
        colEmail.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        colTelepon.setCellValueFactory(cellData -> cellData.getValue().teleponProperty());

        // Set data ke tabel
        tableCustomer.setItems(customerList);
    }

    @FXML
    private void handleTambahCustomer() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/TambahCustomer.fxml"));
            Scene scene = new Scene(loader.load());

            // Get controller dan set reference ke CustomerController
            TambahCustomerController controller = loader.getController();
            controller.setCustomerController(this);

            Stage stage = new Stage();
            stage.setTitle("Tambah Customer");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleEditCustomer() {
        Customer selectedCustomer = tableCustomer.getSelectionModel().getSelectedItem();

        if (selectedCustomer == null) {
            showAlert("Pilih customer yang akan diedit!");
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/EditCustomer.fxml"));
            Scene scene = new Scene(loader.load());

            EditCustomerController controller = loader.getController();
            controller.setCustomer(selectedCustomer);
            controller.setCustomerController(this);

            Stage stage = new Stage();
            stage.setTitle("Edit Customer");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleHapusCustomer() {
        Customer selectedCustomer = tableCustomer.getSelectionModel().getSelectedItem();

        if (selectedCustomer == null) {
            showAlert("Pilih customer yang akan dihapus!");
            return;
        }

        // Tampilkan konfirmasi
        boolean confirmed = showConfirmDialog("Apakah Anda yakin ingin menghapus customer ini?");

        if (confirmed) {
            customerList.remove(selectedCustomer);
        }
    }

    // Method untuk menambah customer ke tabel
    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    // Method untuk refresh tabel
    public void refreshTable() {
        tableCustomer.refresh();
    }

    // Method untuk cek apakah ID sudah ada
    public boolean isIdExists(String id) {
        return customerList.stream().anyMatch(c -> c.getId().equals(id));
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

    private boolean showConfirmDialog(String message) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ConfirmDialog.fxml"));
            Scene scene = new Scene(loader.load());

            ConfirmDialogController controller = loader.getController();
            controller.setMessage(message);

            Stage stage = new Stage();
            stage.setTitle("Konfirmasi");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.showAndWait();

            return controller.isConfirmed();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
