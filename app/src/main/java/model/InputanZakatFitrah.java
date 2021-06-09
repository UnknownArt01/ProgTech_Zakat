package model;

import android.os.Parcel;
import android.os.Parcelable;

public class InputanZakatFitrah implements Parcelable{


    private String image_pathhhh;
    private int hargaberas, hasillll;


    public InputanZakatFitrah() {
        this.image_pathhhh = "";
        this.hargaberas= 0;
        this.hasillll= 0;
    }

    public InputanZakatFitrah(int hargaberas, int hasillll) {
        this.image_pathhhh = "";
        this.hargaberas = hargaberas;
        this.hasillll= hasillll;

    }


    public InputanZakatFitrah(String image_pathhhh, int hargaberas, int hasillll) {
        this.image_pathhhh = image_pathhhh;
        this.hargaberas = hargaberas;
        this.hasillll= hasillll;

    }

    public String getImage_pathhhh() {
        return image_pathhhh;
    }

    public void setImage_pathhhh(String image_pathhhh) {
        this.image_pathhhh = image_pathhhh;
    }

    public int getHargaberas() {
        return hargaberas;
    }

    public void setHargaberas(int hargaberas) {
        this.hargaberas = hargaberas;
    }

    public int getHasillll() {
        return hasillll;
    }

    public void setHasillll(int hasillll) {
        this.hasillll = hasillll;
    }

    public static Parcelable.Creator<InputanZakatFitrah> getCREATOR() {
        return CREATOR;
    }

    protected InputanZakatFitrah(Parcel in) {
        image_pathhhh = in.readString();
        hargaberas = in.readInt();
        hasillll = in.readInt();
    }

    public static final Parcelable.Creator<InputanZakatFitrah> CREATOR = new Parcelable.Creator<InputanZakatFitrah>() {
        @Override
        public InputanZakatFitrah createFromParcel(Parcel in) {
            return new InputanZakatFitrah(in);
        }

        @Override
        public InputanZakatFitrah[] newArray(int size) {
            return new InputanZakatFitrah[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(image_pathhhh);
        dest.writeInt(hargaberas);
        dest.writeInt(hasillll);

    }
}
