package model;

public class Emas {
    private int emas_mentah, emas_pakai, emas_harga, emas_bayar;

    public Emas(int emas_mentah, int emas_pakai, int emas_harga, int emas_bayar) {
        this.emas_mentah = emas_mentah;
        this.emas_pakai = emas_pakai;
        this.emas_harga = emas_harga;
        this.emas_bayar = emas_bayar;
    }

    public Emas() {
        this.emas_mentah = 1;
        this.emas_pakai = 1;
        this.emas_harga = 1;
        this.emas_bayar = 1;
    }

    public int getEmas_mentah() {
        return emas_mentah;
    }

    public void setEmas_mentah(int emas_mentah) {
        this.emas_mentah = emas_mentah;
    }

    public int getEmas_pakai() {
        return emas_pakai;
    }

    public void setEmas_pakai(int emas_pakai) {
        this.emas_pakai = emas_pakai;
    }

    public int getEmas_harga() {
        return emas_harga;
    }

    public void setEmas_harga(int emas_harga) {
        this.emas_harga = emas_harga;
    }

    public int getEmas_bayar() {
        return emas_bayar;
    }

    public void setEmas_bayar(int emas_bayar) {
        this.emas_bayar = emas_bayar;
    }
}
