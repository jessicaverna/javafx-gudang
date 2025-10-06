package com.gudang.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Customer {
    private final StringProperty id;
    private final StringProperty nama;
    private final StringProperty email;
    private final StringProperty telepon;

    public Customer(String id, String nama, String email, String telepon) {
        this.id = new SimpleStringProperty(id);
        this.nama = new SimpleStringProperty(nama);
        this.email = new SimpleStringProperty(email);
        this.telepon = new SimpleStringProperty(telepon);
    }

    // Id property
    public StringProperty idProperty() {
        return id;
    }

    public String getId() {
        return id.get();
    }

    public void setId(String id) {
        this.id.set(id);
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

    // Email property
    public StringProperty emailProperty() {
        return email;
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
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
