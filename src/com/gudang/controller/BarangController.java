package com.gudang.controller;

import com.gudang.model.Barang;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class BarangController {

    @FXML
    private TextField txtNama;

    @FXML
    private TextField txtJumlah;

    @FXML
    private TableView<Barang> tableBarang;

    @FXML
    private TableColumn<Barang, String> colNama;

    @FXML
    private TableColumn<Barang, Number> colJumlah;

    private ObservableList<Barang> barangList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colNama.setCellValueFactory(cell -> cell.getValue().namaProperty());
        colJumlah.setCellValueFactory(cell -> cell.getValue().jumlahProperty());

        tableBarang.setItems(barangList);
    }

    @FXML
    private void tambahBarang() {
        String nama = txtNama.getText();
        String jumlahStr = txtJumlah.getText();

        if (!nama.isEmpty() && !jumlahStr.isEmpty()) {
            try {
                int jumlah = Integer.parseInt(jumlahStr);
                barangList.add(new Barang(nama, jumlah));

                txtNama.clear();
                txtJumlah.clear();
            } catch (NumberFormatException e) {
                // Handle invalid number input
                System.out.println("Jumlah harus berupa angka!");
            }
        }
    }

    @FXML
    private void editBarang() {
        Barang selected = tableBarang.getSelectionModel().getSelectedItem();
        if (selected != null) {
            String nama = txtNama.getText();
            String jumlahStr = txtJumlah.getText();

            if (!nama.isEmpty()) {
                selected.setNama(nama);
            }

            if (!jumlahStr.isEmpty()) {
                try {
                    int jumlah = Integer.parseInt(jumlahStr);
                    selected.setJumlah(jumlah);
                } catch (NumberFormatException e) {
                    System.out.println("Jumlah harus berupa angka!");
                }
            }

            tableBarang.refresh();
            txtNama.clear();
            txtJumlah.clear();
        }
    }

    @FXML
    private void hapusBarang() {
        Barang selected = tableBarang.getSelectionModel().getSelectedItem();
        if (selected != null) {
            barangList.remove(selected);
        }
    }
}
