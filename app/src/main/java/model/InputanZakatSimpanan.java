package model;

import android.os.Parcel;
import android.os.Parcelable;

public class InputanZakatSimpanan implements Parcelable{

    private String image_pathhh;
    private int jsaldo,bungaa, hasilll;

    public InputanZakatSimpanan() {
        this.image_pathhh = "";
        this.jsaldo= 0;
        this.bungaa= 0;
        this.hasilll= 0;

    }

    public InputanZakatSimpanan(int jsaldo, int bungaa, int hasilll) {
        this.image_pathhh = "";
        this.jsaldo = jsaldo;
        this.bungaa = bungaa;
        this.hasilll= hasilll;

    }


    public InputanZakatSimpanan(String image_pathhh, int jsaldo, int bungaa, int hasilll) {
        this.image_pathhh = image_pathhh;
        this.jsaldo = jsaldo;
        this.bungaa = bungaa;
        this.hasilll= hasilll;

    }


    public String getImage_pathhh() {
        return image_pathhh;
    }

    public void setImage_pathhh(String image_pathhh) {
        this.image_pathhh = image_pathhh;
    }

    public int getJsaldo() {
        return jsaldo;
    }

    public void setJsaldo(int jsaldo) {
        this.jsaldo = jsaldo;
    }

    public int getBungaa() {
        return bungaa;
    }

    public void setBungaa(int bungaa) {
        this.bungaa = bungaa;
    }

    public int getHasilll() {
        return hasilll;
    }

    public void setHasilll(int hasilll) {
        this.hasilll = hasilll;
    }

    public static Parcelable.Creator<InputanZakatSimpanan> getCREATOR() {
        return CREATOR;
    }

    protected InputanZakatSimpanan(Parcel in) {
        image_pathhh = in.readString();
        jsaldo = in.readInt();
        bungaa = in.readInt();
        hasilll = in.readInt();
    }

    public static final Parcelable.Creator<InputanZakatSimpanan> CREATOR = new Parcelable.Creator<InputanZakatSimpanan>() {
        @Override
        public InputanZakatSimpanan createFromParcel(Parcel in) {
            return new InputanZakatSimpanan(in);
        }

        @Override
        public InputanZakatSimpanan[] newArray(int size) {
            return new InputanZakatSimpanan[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(image_pathhh);
        dest.writeInt(jsaldo);
        dest.writeInt(bungaa);
        dest.writeInt(hasilll);

    }
}
