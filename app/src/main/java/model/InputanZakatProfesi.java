package model;

import android.os.Parcel;
import android.os.Parcelable;

public class InputanZakatProfesi implements Parcelable{
    private String image_path;
    private int penghasilanperbulan, penghasilantambahan, cicilandanpokok, hasil;

    public InputanZakatProfesi() {
        this.image_path = "";
        this.penghasilanperbulan= 0;
        this.penghasilantambahan= 0;
        this.cicilandanpokok= 0;
        this.hasil= 0;
    }

    public InputanZakatProfesi(int penghasilanperbulan, int penghasilantambahan, int cicilandanpokok, int hasil) {
        this.image_path = "";
        this.penghasilanperbulan = penghasilanperbulan;
        this.penghasilantambahan = penghasilantambahan;
        this.cicilandanpokok = cicilandanpokok;
        this.hasil= hasil;

    }


    public InputanZakatProfesi(String image_path, int penghasilanperbulan, int penghasilantambahan, int cicilandanpokok, int hasil) {
        this.image_path = image_path;
        this.penghasilanperbulan = penghasilanperbulan;
        this.penghasilantambahan = penghasilantambahan;
        this.cicilandanpokok = cicilandanpokok;
        this.hasil= hasil;

    }


    public static Parcelable.Creator<InputanZakatProfesi> getCREATOR() {
        return CREATOR;
    }

    public int getHasil() {
        return hasil;
    }

    public void setHasil(int hasil) {
        this.hasil = hasil;
    }

    public int getPenghasilantambahan() {
        return penghasilantambahan;
    }

    public int getCicilandanpokok() {
        return cicilandanpokok;
    }

    public void setCicilandanpokok(int cicilandanpokok) {

        this.cicilandanpokok = cicilandanpokok;
    }

    public void setPenghasilantambahan(int penghasilantambahan) {
        this.penghasilantambahan = penghasilantambahan;
    }

    public int getPenghasilanperbulan() {
        return penghasilanperbulan;
    }

    public void setPenghasilanperbulan(int penghasilanperbulan) {
        this.penghasilanperbulan = penghasilanperbulan;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    protected InputanZakatProfesi(Parcel in) {
        image_path = in.readString();
        penghasilanperbulan = in.readInt();
        penghasilantambahan = in.readInt();
        cicilandanpokok = in.readInt();
        hasil = in.readInt();

    }

    public static final Parcelable.Creator<InputanZakatProfesi> CREATOR = new Parcelable.Creator<InputanZakatProfesi>() {
        @Override
        public InputanZakatProfesi createFromParcel(Parcel in) {
            return new InputanZakatProfesi(in);
        }

        @Override
        public InputanZakatProfesi[] newArray(int size) {
            return new InputanZakatProfesi[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(image_path);
        dest.writeInt(penghasilanperbulan);
        dest.writeInt(penghasilantambahan);
        dest.writeInt(cicilandanpokok);
        dest.writeInt(hasil);

    }


}
