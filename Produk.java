package manajemenProduk.model;

// PEWARISAN
public class Produk extends Item {
    int stok;

    public Produk(String nama, int harga, int stok) {
        super(nama, harga);
        this.stok = stok;
    }

    // POLIMORFISME (override)
    @Override
    public void tampil() {
        System.out.println(nama + " | Rp." + harga + " | Stok: " + stok);
    }
    public int getStok() {
        return stok;
    }
    
    public void setingHarga(int harga) {
    this.harga = harga;
    }
    public void setingStok(int stok) {
    this.stok = stok;
    }
}
