package manajemenProduk.model;

// PEWARISAN
public class Produk extends Item {

    int stok;
    int diskon = 0;

    public Produk(String nama, int harga, int stok) {

        super(nama, harga);

        this.stok = stok;
    }

    // POLIMORFISME (override)
    @Override
    public void tampil() {

        System.out.println(
            nama + " | Rp." + harga + " | Stok: " + stok
        );
    }

    // GETTER
    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    public int getDiskon() {
        return diskon;
    }

    // SETTER
    public void setingHarga(int harga) {
        this.harga = harga;
    }

    public void setingStok(int stok) {
        this.stok = stok;
    }

    public void setDiskon(int diskon) {
        this.diskon = diskon;
    }
}