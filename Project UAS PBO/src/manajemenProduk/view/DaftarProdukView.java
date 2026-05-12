package manajemenProduk.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.geometry.Insets;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.layout.VBox;

import manajemenProduk.model.Produk;
import manajemenProduk.services.GudangManager;

public class DaftarProdukView {

    GudangManager gm;

    public DaftarProdukView(GudangManager gm) {
        this.gm = gm;
    }

    public VBox getView() {

        VBox root = new VBox(15);

        root.setPadding(new Insets(20));

        // =========================
        // TITLE
        // =========================
        Label title = new Label("Daftar Produk");

        title.setStyle(
            "-fx-font-size: 24px;" +
            "-fx-font-weight: bold;"
        );

        // =========================
        // TABLE
        // =========================
        TableView<Produk> table = new TableView<>();

        // KOLOM NAMA
        TableColumn<Produk, String> colNama =
            new TableColumn<>("Nama");

        colNama.setCellValueFactory(
            new PropertyValueFactory<>("nama")
        );

        // KOLOM HARGA
        TableColumn<Produk, Integer> colHarga =
            new TableColumn<>("Harga");

        colHarga.setCellValueFactory(
            new PropertyValueFactory<>("harga")
        );

        // KOLOM STOK
        TableColumn<Produk, Integer> colStok =
            new TableColumn<>("Stok");

        colStok.setCellValueFactory(
            new PropertyValueFactory<>("stok")
        );

        // TAMBAH KOLOM KE TABLE
        table.getColumns().add(colNama);
        table.getColumns().add(colHarga);
        table.getColumns().add(colStok);
        
        // DATA
        ObservableList<Produk> data =
            FXCollections.observableArrayList(
                gm.getDaftar()
            );

        table.setItems(data);

        table.setPrefHeight(400);

        root.getChildren().addAll(
            title,
            table
        );

        return root;
    }
}