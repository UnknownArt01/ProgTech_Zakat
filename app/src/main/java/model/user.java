package model;

import android.os.Parcel;
import android.os.Parcelable;

public class user implements Parcelable {

    private String nama, email, password;

    public user() {
        this.nama = "";
        this.email = "";
        this.password = "";
    }

    public user(String nama, String email, String password) {
        this.nama = nama;
        this.email = email;
        this.password = password;
    }

    protected user(Parcel in) {
        nama = in.readString();
        email = in.readString();
        password = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(email);
        dest.writeString(password);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<user> CREATOR = new Creator<user>() {
        @Override
        public user createFromParcel(Parcel in) {
            return new user(in);
        }

        @Override
        public user[] newArray(int size) {
            return new user[size];
        }
    };

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
