package model;

import android.os.Parcel;
import android.os.Parcelable;

public class Maal implements Parcelable {
    private int harta, zakat_maal;

    public Maal(int harta, int zakat_maal) {
        this.harta = harta;
        this.zakat_maal = zakat_maal;
    }
    public Maal() {
        this.harta = 1;
        this.zakat_maal = 1;
    }

    protected Maal(Parcel in) {
        harta = in.readInt();
        zakat_maal = in.readInt();
    }

    public static final Creator<Maal> CREATOR = new Creator<Maal>() {
        @Override
        public Maal createFromParcel(Parcel in) {
            return new Maal(in);
        }

        @Override
        public Maal[] newArray(int size) {
            return new Maal[size];
        }
    };

    public int getHarta() {
        return harta;
    }

    public void setHarta(int harta) {
        this.harta = harta;
    }

    public int getZakat_maal() {
        return zakat_maal;
    }

    public void setZakat_maal(int zakat_maal) {
        this.zakat_maal = zakat_maal;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(harta);
        dest.writeInt(zakat_maal);
    }
}
