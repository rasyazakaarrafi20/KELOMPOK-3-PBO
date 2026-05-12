package manajemenProduk.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.geometry.Insets;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import javafx.scene.layout.VBox;

import manajemenProduk.model.Produk;
import manajemenProduk.services.GudangManager;

public class HapusProdukView {

    GudangManager gm;

    public HapusProdukView(GudangManager gm) {
        this.gm = gm;
    }

    public VBox getView() {

        VBox root = new VBox(15);

        root.setPadding(new Insets(20));

        // =========================
        // TITLE
        // =========================
        Label title = new Label("Hapus Produk");

        title.setStyle(
            "-fx-font-size: 24px;" +
            "-fx-font-weight: bold;"
        );

        // =========================
        // LIST PRODUK
        // =========================
        ListView<String> listProduk =
            new ListView<>();

        ObservableList<String> data =
            FXCollections.observableArrayList();

        // AMBIL DATA PRODUK
        for (Produk p : gm.getDaftar()) {

            data.add(
                p.getNama()
            );
        }

        listProduk.setItems(data);

        listProduk.setPrefHeight(300);

        // =========================
        // BUTTON HAPUS
        // =========================
        Button btnHapus =
            new Button("Hapus Produk");

        btnHapus.setStyle(
            "-fx-background-color: #e74c3c;" +
            "-fx-text-fill: white;" +
            "-fx-font-size: 14px;"
        );

        // STATUS
        Label status = new Label();

        // =========================
        // ACTION
        // =========================
        btnHapus.setOnAction(e -> {

            String selected =
                listProduk
                    .getSelectionModel()
                    .getSelectedItem();

            if (selected != null) {

                gm.hapusProduk(selected);

                data.remove(selected);

                status.setText(
                    "Produk berhasil dihapus!"
                );

            } else {

                status.setText(
                    "Pilih produk dulu!"
                );
            }
        });

        root.getChildren().addAll(
            title,
            listProduk,
            btnHapus,
            status
        );

        return root;
    }
}