package model;

import android.os.Parcel;
import android.os.Parcelable;

public class Perdagangan implements Parcelable {
    private int modal, keuntungan, piutang, hutang, kerugian, zakat_perdagangan;

    public Perdagangan(int modal, int keuntungan, int piutang, int hutang, int kerugian, int zakat_perdagangan) {
        this.modal = modal;
        this.keuntungan = keuntungan;
        this.piutang = piutang;
        this.hutang = hutang;
        this.kerugian = kerugian;
        this.zakat_perdagangan = zakat_perdagangan;
    }
    public Perdagangan() {
        this.modal = 1;
        this.keuntungan = 1;
        this.piutang = 1;
        this.hutang = 1;
        this.kerugian = 1;
        this.zakat_perdagangan = 1;
    }

    protected Perdagangan(Parcel in) {
        modal = in.readInt();
        keuntungan = in.readInt();
        piutang = in.readInt();
        hutang = in.readInt();
        kerugian = in.readInt();
        zakat_perdagangan = in.readInt();
    }

    public static final Creator<Perdagangan> CREATOR = new Creator<Perdagangan>() {
        @Override
        public Perdagangan createFromParcel(Parcel in) {
            return new Perdagangan(in);
        }

        @Override
        public Perdagangan[] newArray(int size) {
            return new Perdagangan[size];
        }
    };

    public int getModal() {
        return modal;
    }

    public void setModal(int modal) {
        this.modal = modal;
    }

    public int getKeuntungan() {
        return keuntungan;
    }

    public void setKeuntungan(int keuntungan) {
        this.keuntungan = keuntungan;
    }

    public int getPiutang() {
        return piutang;
    }

    public void setPiutang(int piutang) {
        this.piutang = piutang;
    }

    public int getHutang() {
        return hutang;
    }

    public void setHutang(int hutang) {
        this.hutang = hutang;
    }

    public int getKerugian() {
        return kerugian;
    }

    public void setKerugian(int kerugian) {
        this.kerugian = kerugian;
    }

    public int getZakat_perdagangan() {
        return zakat_perdagangan;
    }

    public void setZakat_perdagangan(int zakat_perdagangan) {
        this.zakat_perdagangan = zakat_perdagangan;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(modal);
        dest.writeInt(keuntungan);
        dest.writeInt(piutang);
        dest.writeInt(hutang);
        dest.writeInt(kerugian);
        dest.writeInt(zakat_perdagangan);
    }
}
