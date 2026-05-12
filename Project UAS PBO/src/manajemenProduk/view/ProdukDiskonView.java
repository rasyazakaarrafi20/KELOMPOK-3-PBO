package manajemenProduk.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.geometry.Insets;

import javafx.scene.control.*;

import javafx.scene.layout.VBox;

import manajemenProduk.model.Produk;
import manajemenProduk.model.ProdukDiskon;

import manajemenProduk.services.GudangManager;

public class ProdukDiskonView {

    GudangManager gm;

    Produk produkDipilih;
    int hargaDiskon;
    int diskonValue;

    public ProdukDiskonView(GudangManager gm) {
        this.gm = gm;
    }

    public VBox getView() {

        VBox root = new VBox(15);

        root.setPadding(new Insets(20));

        // =========================
        // TITLE
        // =========================
        Label title =
            new Label("Produk Diskon");

        title.setStyle(
            "-fx-font-size: 24px;" +
            "-fx-font-weight: bold;"
        );

        // =========================
        // PILIH PRODUK
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
        // INPUT DISKON
        // =========================
        TextField tfDiskon =
            new TextField();

        tfDiskon.setPromptText(
            "Masukkan Diskon (%)"
        );

        // =========================
        // BUTTON
        // =========================
        Button btnHitung =
            new Button("Hitung Diskon");

        Button btnTetapkan =
            new Button("Tetapkan Diskon");

        btnHitung.setStyle(
            "-fx-background-color: #9b59b6;" +
            "-fx-text-fill: white;" +
            "-fx-font-size: 14px;"
        );

        btnTetapkan.setStyle(
            "-fx-background-color: #27ae60;" +
            "-fx-text-fill: white;" +
            "-fx-font-size: 14px;"
        );

        // HASIL
        Label hasil = new Label();

        // ACTION
        btnHitung.setOnAction(e -> {

            String nama =
                cbProduk.getValue();

            if (nama == null) {

                hasil.setText(
                    "Pilih produk dulu!"
                );

                return;
            }

            try {

                int diskon =
                    Integer.parseInt(
                        tfDiskon.getText()
                    );

                Produk p =
                    gm.cariNama(nama);
                    produkDipilih = p;
                    diskonValue = diskon;
                    

                if (p != null) {

                    // INHERITANCE
                    ProdukDiskon pd =
                        new ProdukDiskon(
                            p.getNama(),
                            p.getHarga(),
                            p.getStok(),
                            diskon
                        );

                    hargaDiskon = pd.hargaSetelahDiskon();
                    hasil.setText(
                        "Harga Awal : Rp." +
                        p.getHarga() +

                        "\nDiskon : " +
                        diskon + "%" +

                        "\nHarga Setelah Diskon : Rp." +
                        hargaDiskon
                    );
                }

            } catch (Exception ex) {

                hasil.setText(
                    "Input tidak valid!"
                );
            }
        });

        // ACTION TETAPKAN
        btnTetapkan.setOnAction(e -> {

            if (produkDipilih != null) {
                produkDipilih.setingHarga(
                    hargaDiskon
                );

                produkDipilih.setDiskon(
                    diskonValue
                );

                gm.tambahProdukDiskon(
                    produkDipilih
                );

                hasil.setText(
                    "Diskon berhasil diterapkan!"
                );
            }
        });

        root.getChildren().addAll(
            title,
            cbProduk,
            tfDiskon,
            btnHitung,
            btnTetapkan,
            hasil
        );

        return root;
    }
}