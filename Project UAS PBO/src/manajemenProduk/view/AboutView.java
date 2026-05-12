package manajemenProduk.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.control.Label;

import javafx.scene.layout.VBox;

public class AboutView {

    public VBox getView() {

        VBox root = new VBox(20);

        root.setPadding(new Insets(30));

        root.setAlignment(Pos.TOP_LEFT);

        // =========================
        // TITLE
        // =========================
        Label title =
            new Label("About Program");

        title.setStyle(
            "-fx-font-size: 28px;" +
            "-fx-font-weight: bold;"
        );

        // =========================
        // DESKRIPSI
        // =========================
        Label desc =
            new Label(

                "Program ini dibuat untuk memenuhi\n" +

                "Project UAS Mata Kuliah Pemrograman Berorientasi Objek.\n\n" +

                "Aplikasi ini digunakan untuk:\n" +

                "- Mengelola produk\n" +
                "- Menambah produk\n" +
                "- Mengedit produk\n" +
                "- Menghapus produk\n" +
                "- Mengatur diskon produk\n\n" +

                "Teknologi yang digunakan:\n" +

                "- Java\n" +
                "- JavaFX\n" +
                "- Konsep OOP"
            );

        desc.setStyle(
            "-fx-font-size: 16px;"
        );

        // =========================
        // ANGGOTA
        // =========================
        Label anggotaTitle =
            new Label("Anggota Kelompok");

        anggotaTitle.setStyle(
            "-fx-font-size: 22px;" +
            "-fx-font-weight: bold;"
        );

        Label anggota =
            new Label(

                "1. Andhika Annas Satria\n" +
                "2. Rasya Zaka Arrafi\n"
            );

        anggota.setStyle(
            "-fx-font-size: 16px;"
        );

        // =========================
        // FOOTER
        // =========================
        Label footer =
            new Label(
                "Manajemen Produk App 2026"
            );

        footer.setStyle(
            "-fx-text-fill: gray;"
        );

        root.getChildren().addAll(
            title,
            desc,
            anggotaTitle,
            anggota,
            footer
        );

        return root;
    }
}