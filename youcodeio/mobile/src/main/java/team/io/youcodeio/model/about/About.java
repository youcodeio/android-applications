package team.io.youcodeio.model.about;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by stevenwatremez on 15/01/16.
 *
 */
public class About implements Parcelable{

    /*****************************************************************
     * DATA
     ****************************************************************/
    public String id;
    public String name;
    public String skills;
    public String description;
    public List<SocialNetwork> socialNetworkList;

    /*****************************************************************
     * CONSTRUCTOR
     ****************************************************************/
    public About(@NonNull final String id,
                 @NonNull final String name,
                 @NonNull final String skills,
                 @NonNull final String description,
                 @NonNull final List<SocialNetwork> socialNetworkList) {
        this.id = id;
        this.name = name;
        this.skills = skills;
        this.description = description;
        this.socialNetworkList = socialNetworkList;
    }

    /*****************************************************************
     * PARCELABLE
     ****************************************************************/
    protected About(Parcel in) {
        id = in.readString();
        name = in.readString();
        skills = in.readString();
        description = in.readString();
    }

    public static final Creator<About> CREATOR = new Creator<About>() {
        @Override
        public About createFromParcel(Parcel in) {
            return new About(in);
        }

        @Override
        public About[] newArray(int size) {
            return new About[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(name);
        parcel.writeString(skills);
        parcel.writeString(description);
    }
}
