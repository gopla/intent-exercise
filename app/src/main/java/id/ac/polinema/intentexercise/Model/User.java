package id.ac.polinema.intentexercise.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private String fullName, email, password, homepage, about;

    public User(String fullName, String email, String password, String homepage, String about) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.homepage = homepage;
        this.about = about;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.fullName);
        dest.writeString(this.email);
        dest.writeString(this.password);
        dest.writeString(this.homepage);
        dest.writeString(this.about);
    }

    protected User(Parcel in) {
        this.fullName = in.readString();
        this.email = in.readString();
        this.password = in.readString();
        this.homepage = in.readString();
        this.about = in.readString();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
