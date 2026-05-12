package manajemenProduk.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.geometry.Insets;

import javafx.scene.control.*;

import javafx.scene.layout.VBox;

import manajemenProduk.model.Produk;
import manajemenProduk.services.GudangManager;

public class EditProdukView {

    GudangManager gm;

    public EditProdukView(GudangManager gm) {
        this.gm = gm;
    }

    public VBox getView() {

        VBox root = new VBox(15);

        root.setPadding(new Insets(20));

        // =========================
        // TITLE
        // =========================
        Label title = new Label("Edit Produk");

        title.setStyle(
            "-fx-font-size: 24px;" +
            "-fx-font-weight: bold;"
        );

        // =========================
        // LIST PRODUK
        // =========================
        ComboBox<String> cbProduk =
            new ComboBox<>();

        ObservableList<String> data =
            FXCollections.observableArrayList();

        for (Produk p : gm.getDaftar()) {

            data.add(
                p.getNama()
            );
        }

        cbProduk.setItems(data);

        cbProduk.setPromptText(
            "Pilih Produk"
        );

        // =========================
        // INPUT
        // =========================
        TextField tfHarga =
            new TextField();

        tfHarga.setPromptText(
            "Harga Baru"
        );

        TextField tfStok =
            new TextField();

        tfStok.setPromptText(
            "Stok Baru"
        );

        // =========================
        // BUTTON
        // =========================
        Button btnUpdate =
            new Button("Update Produk");

        btnUpdate.setStyle(
            "-fx-background-color: #f39c12;" +
            "-fx-text-fill: white;" +
            "-fx-font-size: 14px;"
        );

        // STATUS
        Label status = new Label();

        // =========================
        // ACTION
        // =========================
        btnUpdate.setOnAction(e -> {

            String nama =
                cbProduk.getValue();

            if (nama == null) {

                status.setText(
                    "Pilih produk dulu!"
                );

                return;
            }

            try {

                int hargaBaru =
                    Integer.parseInt(
                        tfHarga.getText()
                    );

                int stokBaru =
                    Integer.parseInt(
                        tfStok.getText()
                    );

                Produk produk =
                    gm.cariNama(nama);

                if (produk != null) {

                    produk.setingHarga(
                        hargaBaru
                    );

                    produk.setingStok(
                        stokBaru
                    );

                    status.setText(
                        "Produk berhasil diupdate!"
                    );
                }

            } catch (Exception ex) {

                status.setText(
                    "Input tidak valid!"
                );
            }
        });

        root.getChildren().addAll(
            title,
            cbProduk,
            tfHarga,
            tfStok,
            btnUpdate,
            status
        );

        return root;
    }
}