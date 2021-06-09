package model;

import android.os.Parcel;
import android.os.Parcelable;

public class Perak implements Parcelable {
    private int perak, harga_perak, zakat_perak;

    public Perak(int perak, int harga_perak, int zakat_perak) {
        this.perak = perak;
        this.harga_perak = harga_perak;
        this.zakat_perak = zakat_perak;
    }
    public Perak() {
        this.perak = 1;
        this.harga_perak = 1;
        this.zakat_perak = 1;
    }

    protected Perak(Parcel in) {
        perak = in.readInt();
        harga_perak = in.readInt();
        zakat_perak = in.readInt();
    }

    public static final Creator<Perak> CREATOR = new Creator<Perak>() {
        @Override
        public Perak createFromParcel(Parcel in) {
            return new Perak(in);
        }

        @Override
        public Perak[] newArray(int size) {
            return new Perak[size];
        }
    };

    public int getPerak() {
        return perak;
    }

    public void setPerak(int perak) {
        this.perak = perak;
    }

    public int getHarga_perak() {
        return harga_perak;
    }

    public void setHarga_perak(int harga_perak) {
        this.harga_perak = harga_perak;
    }

    public int getZakat_perak() {
        return zakat_perak;
    }

    public void setZakat_perak(int zakat_perak) {
        this.zakat_perak = zakat_perak;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(perak);
        dest.writeInt(harga_perak);
        dest.writeInt(zakat_perak);
    }
}
