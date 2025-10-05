package com.gudang.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Supplier {
    private final StringProperty nama;
    private final StringProperty alamat;
    private final StringProperty telepon;

    public Supplier(String nama, String alamat, String telepon) {
        this.nama = new SimpleStringProperty(nama);
        this.alamat = new SimpleStringProperty(alamat);
        this.telepon = new SimpleStringProperty(telepon);
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

    // Alamat property
    public StringProperty alamatProperty() {
        return alamat;
    }

    public String getAlamat() {
        return alamat.get();
    }

    public void setAlamat(String alamat) {
        this.alamat.set(alamat);
    }

    // Telepon property
    public StringProperty teleponProperty() {
        return telepon;
    }

    public String getTelepon() {
        return telepon.get();
    }

    public void setTelepon(String telepon) {
        this.telepon.set(telepon);
    }
}
