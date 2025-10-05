package com.gudang.controller;

import com.gudang.model.Supplier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class SupplierController {

    @FXML
    private TextField txtNama;

    @FXML
    private TextField txtAlamat;

    @FXML
    private TextField txtTelepon;

    @FXML
    private TableView<Supplier> tableSupplier;

    @FXML
    private TableColumn<Supplier, String> colNama;

    @FXML
    private TableColumn<Supplier, String> colAlamat;

    @FXML
    private TableColumn<Supplier, String> colTelepon;

    private ObservableList<Supplier> supplierList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colNama.setCellValueFactory(cell -> cell.getValue().namaProperty());
        colAlamat.setCellValueFactory(cell -> cell.getValue().alamatProperty());
        colTelepon.setCellValueFactory(cell -> cell.getValue().teleponProperty());

        tableSupplier.setItems(supplierList);
    }

    @FXML
    private void tambahSupplier() {
        String nama = txtNama.getText();
        String alamat = txtAlamat.getText();
        String telepon = txtTelepon.getText();

        if (!nama.isEmpty() && !alamat.isEmpty() && !telepon.isEmpty()) {
            supplierList.add(new Supplier(nama, alamat, telepon));

            txtNama.clear();
            txtAlamat.clear();
            txtTelepon.clear();
        }
    }

    @FXML
    private void editSupplier() {
        Supplier selected = tableSupplier.getSelectionModel().getSelectedItem();
        if (selected != null) {
            String nama = txtNama.getText();
            String alamat = txtAlamat.getText();
            String telepon = txtTelepon.getText();

            if (!nama.isEmpty()) {
                selected.setNama(nama);
            }

            if (!alamat.isEmpty()) {
                selected.setAlamat(alamat);
            }

            if (!telepon.isEmpty()) {
                selected.setTelepon(telepon);
            }

            tableSupplier.refresh();
            txtNama.clear();
            txtAlamat.clear();
            txtTelepon.clear();
        }
    }

    @FXML
    private void hapusSupplier() {
        Supplier selected = tableSupplier.getSelectionModel().getSelectedItem();
        if (selected != null) {
            supplierList.remove(selected);
        }
    }
}
