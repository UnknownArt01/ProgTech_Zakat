package model;

import android.os.Parcel;
import android.os.Parcelable;

public class InputanZakatTemuan implements Parcelable {

    private String image_pathh;
    private int perkiraanharga, hasill;


    public InputanZakatTemuan() {
        this.image_pathh = "";
        this.perkiraanharga= 0;
        this.hasill= 0;
    }

    public InputanZakatTemuan(int perkiraanharga, int hasill) {
        this.image_pathh = "";
        this.perkiraanharga = perkiraanharga;
        this.hasill= hasill;

    }


    public InputanZakatTemuan(String image_pathh, int perkiraanharga, int hasill) {
        this.image_pathh = image_pathh;
        this.perkiraanharga = perkiraanharga;
        this.hasill= hasill;

    }

    public String getImage_pathh() {
        return image_pathh;
    }

    public void setImage_pathh(String image_pathh) {
        this.image_pathh = image_pathh;
    }

    public int getPerkiraanharga() {
        return perkiraanharga;
    }

    public void setPerkiraanharga(int perkiraanharga) {
        this.perkiraanharga = perkiraanharga;
    }

    public int getHasill() {
        return hasill;
    }

    public void setHasill(int hasill) {
        this.hasill = hasill;
    }

    public static Parcelable.Creator<InputanZakatTemuan> getCREATOR() {
        return CREATOR;
    }

    protected InputanZakatTemuan(Parcel in) {
        image_pathh = in.readString();
        perkiraanharga = in.readInt();
        hasill = in.readInt();
    }

    public static final Parcelable.Creator<InputanZakatTemuan> CREATOR = new Parcelable.Creator<InputanZakatTemuan>() {
        @Override
        public InputanZakatTemuan createFromParcel(Parcel in) {
            return new InputanZakatTemuan(in);
        }

        @Override
        public InputanZakatTemuan[] newArray(int size) {
            return new InputanZakatTemuan[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(image_pathh);
        dest.writeInt(perkiraanharga);
        dest.writeInt(hasill);

    }
}
