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
        // TODO: Implementasi edit customer
    }

    @FXML
    private void handleHapusCustomer() {
        // TODO: Implementasi hapus customer
    }

    // Method untuk menambah customer ke tabel
    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    // Method untuk cek apakah ID sudah ada
    public boolean isIdExists(String id) {
        return customerList.stream().anyMatch(c -> c.getId().equals(id));
    }
}
