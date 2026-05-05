package manajemenProduk.services;

import java.util.ArrayList;
import manajemenProduk.model.Produk;

public class GudangManager {

    ArrayList<Produk> daftar = new ArrayList<>();

    // TAMBAH
    public void tambahProduk(Produk p) {
        daftar.add(p);
    }

    // TAMPIL
    public void tampilSemua() {
        if (daftar.isEmpty()) {
            System.out.println("Belum ada produk.");
            return;
        }

        for (Produk p : daftar) {
            p.tampil();
        }
    }

    // HAPUS
    public void hapusProduk(String nama) {
        boolean ditemukan = false;

        for (int i = 0; i < daftar.size(); i++) {
            if (daftar.get(i).getNama().equalsIgnoreCase(nama)) {
                daftar.remove(i);
                ditemukan = true;
                System.out.println("Produk berhasil dihapus.");
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Produk tidak ditemukan.");
        }
    }

    // HOME
    public int totalProduk() {
        return daftar.size();
    }

    public int totalStok() {
        int total = 0;
        for (Produk p : daftar) {
            total += p.getStok();
        }
        return total;
    }

    public void produkBaru() {
        if (!daftar.isEmpty()) {
            System.out.println("Produk terbaru:");
            daftar.get(daftar.size() - 1).tampil();
        } else {
            System.out.println("Belum ada produk.");
        }
    }

    //  BUBBLE SORT (HARGA)
    public void sortHarga() {
        for (int i = 0; i < daftar.size() - 1; i++) {
            for (int j = 0; j < daftar.size() - 1 - i; j++) {

                if (daftar.get(j).getHarga() > daftar.get(j + 1).getHarga()) {

                    // swap
                    Produk temp = daftar.get(j);
                    daftar.set(j, daftar.get(j + 1));
                    daftar.set(j + 1, temp);
                }
            }
        }
    }
    //  LINEAR SEARCH (NAMA)
    public Produk cariNama(String nama) {
        for (int i = 0; i < daftar.size(); i++) {

            if (daftar.get(i).getNama().equalsIgnoreCase(nama)) {
                return daftar.get(i);
            }
        }
        return null;
    }
}
