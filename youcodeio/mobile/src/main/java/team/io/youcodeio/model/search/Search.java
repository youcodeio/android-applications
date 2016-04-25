package team.io.youcodeio.model.search;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by stevenwatremez on 08/03/16.
 *
 */
public class Search implements Parcelable {

    /*****************************************************************
     * DATA
     ****************************************************************/
    @SerializedName("etag") public String youtubeId;
    @SerializedName("kind") public String kind;
    @SerializedName("snippet") public VideoFromSearch snippet;

    /*****************************************************************
     * CONSTRUCTOR
     ****************************************************************/
    public Search() {}

    /*****************************************************************
     * PARCELABLE
     ****************************************************************/
    protected Search(Parcel in) {
        youtubeId = in.readString();
        kind = in.readString();
        snippet = in.readParcelable(VideoFromSearch.class.getClassLoader());
    }

    public static final Creator<Search> CREATOR = new Creator<Search>() {
        @Override
        public Search createFromParcel(Parcel in) {
            return new Search(in);
        }

        @Override
        public Search[] newArray(int size) {
            return new Search[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(youtubeId);
        parcel.writeString(kind);
        parcel.writeParcelable(snippet, i);
    }
}
