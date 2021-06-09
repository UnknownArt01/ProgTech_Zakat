package model;

import android.os.Parcel;
import android.os.Parcelable;

public class Emas implements Parcelable {
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

    protected Emas(Parcel in) {
        emas_mentah = in.readInt();
        emas_pakai = in.readInt();
        emas_harga = in.readInt();
        emas_bayar = in.readInt();
    }

    public static final Creator<Emas> CREATOR = new Creator<Emas>() {
        @Override
        public Emas createFromParcel(Parcel in) {
            return new Emas(in);
        }

        @Override
        public Emas[] newArray(int size) {
            return new Emas[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(emas_mentah);
        dest.writeInt(emas_pakai);
        dest.writeInt(emas_harga);
        dest.writeInt(emas_bayar);
    }
}
