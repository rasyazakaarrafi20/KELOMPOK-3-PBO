package manajemenProduk.mainprogram;

import java.util.Scanner;
import manajemenProduk.services.GudangManager;
import manajemenProduk.model.Produk;
import manajemenProduk.model.ProdukDiskon;

// MAIN CLASS
public class MainMenu {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        GudangManager gm = new GudangManager();

        int pilih;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Home");
            System.out.println("2. Tambah Produk");
            System.out.println("3. Lihat Daftar");
            System.out.println("4. Hapus Produk");
            System.out.println("5. Edit Produk");
            System.out.println("6. Produk Diskon");
            System.out.println("0. Keluar");

            System.out.print("Pilih: ");
            pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {

                case 1:
                    System.out.println("\n=== HOME ===");
                    System.out.println("Total Produk: " + gm.totalProduk());
                    System.out.println("Total Stok: " + gm.totalStok());
                    gm.produkBaru();
                    break;

                case 2:
                    System.out.print("Nama: ");
                    String nama = input.nextLine();

                    System.out.print("Harga: ");
                    int harga = input.nextInt();

                    System.out.print("Stok: ");
                    int stok = input.nextInt();
                    input.nextLine();

                    gm.tambahProduk(new Produk(nama, harga, stok));
                    break;

                case 3:
                    gm.sortHarga();
                    gm.tampilSemua();
                    break;

                case 4:
                    System.out.print("Nama produk: ");
                    String hapus = input.nextLine();
                    gm.hapusProduk(hapus);
                    break;

                case 5:
                    System.out.print("Nama produk yang mau diedit: ");
                    String namaEdit = input.nextLine();

                    Produk produk = gm.cariProduk(namaEdit);

                    if (produk == null) {
                        System.out.println("Produk tidak ditemukan!");
                        break;
                    }

                    System.out.print("Harga baru: ");
                    int hargaBaru = input.nextInt();

                    System.out.print("Stok baru: ");
                    int stokBaru = input.nextInt();
                    input.nextLine();

                    ep.editProduk(gm.getDaftar(), namaEdit, hargaBaru, stokBaru);
                    break;

                case 6:
                    ProdukDiskon pd = new ProdukDiskon("Laptop", 8000000, 5, 10);
                    pd.tampil();
                    break;
            }

        } while (pilih != 0);

        input.close();
    }
}
