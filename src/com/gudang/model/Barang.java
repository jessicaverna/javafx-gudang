package com.gudang.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Barang {
    private final StringProperty nama;
    private final IntegerProperty jumlah;

    public Barang(String nama, int jumlah) {
        this.nama = new SimpleStringProperty(nama);
        this.jumlah = new SimpleIntegerProperty(jumlah);
    }

    // Nama property
    public StringProperty namaProperty() {
        return nama;
    }

    public String getNama() {
        return nama.get();
    }

    public void setNama(String nama) {
        this.nama.set(nama);
    }

    // Jumlah property
    public IntegerProperty jumlahProperty() {
        return jumlah;
    }

    public int getJumlah() {
        return jumlah.get();
    }

    public void setJumlah(int jumlah) {
        this.jumlah.set(jumlah);
    }
}
