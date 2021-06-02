package model;

import android.os.Parcel;
import android.os.Parcelable;

public class maal implements Parcelable {
    private int harta;
    private int jumlah_mall;

    protected maal(Parcel in) {
        harta = in.readInt();
        jumlah_mall = in.readInt();
    }

    public static final Creator<maal> CREATOR = new Creator<maal>() {
        @Override
        public maal createFromParcel(Parcel in) {
            return new maal(in);
        }

        @Override
        public maal[] newArray(int size) {
            return new maal[size];
        }
    };

    public int getHarta() {
        return harta;
    }

    public void setHarta(int harta) {
        this.harta = harta;
    }

    public int getJumlah_mall() {
        return jumlah_mall;
    }

    public void setJumlah_mall(int jumlah_mall) {
        this.jumlah_mall = jumlah_mall;
    }

    public maal(int harta, int jumlah_mall) {
        this.harta = harta;
        this.jumlah_mall = jumlah_mall;
    }
    public maal() {
        this.harta = 0;
        this.jumlah_mall = 0;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(harta);
        dest.writeInt(jumlah_mall);
    }
}
