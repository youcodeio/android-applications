package team.io.youcodeio.model.search;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by stevenwatremez on 03/04/16.
 *
 */
public class VideoFromSearch implements Parcelable {

    /*****************************************************************
     * DATA
     ****************************************************************/
    @SerializedName("channelId") public String channelId;
    @SerializedName("channelTitle") public String channelTitle;
    @SerializedName("description") public String description;
    @SerializedName("publishedAt") public String publishedAt;
    @SerializedName("title") public String title;
    @SerializedName("thumbnails") public Thumbnail thumbnails;



    public class Thumbnail {
        @SerializedName("default") public DefaultResolution defaultResolution;
        @SerializedName("high") public HighResolution highResolution;
        @SerializedName("medium") public MediumResolution mediumResolution;
    }

    public class HighResolution {
        @SerializedName("url") public String url;
    }
    public class DefaultResolution {
        @SerializedName("url") public String url;
    }
    public class MediumResolution {
        @SerializedName("url") public String url;
    }

    /*****************************************************************
     * CONSTRUCTOR
     ****************************************************************/
    public VideoFromSearch() {}

    /*****************************************************************
     * PARCELABLE
     ****************************************************************/
    protected VideoFromSearch(Parcel in) {
        channelId = in.readString();
        channelTitle = in.readString();
        description = in.readString();
        publishedAt = in.readString();
        title = in.readString();
    }

    public static final Creator<VideoFromSearch> CREATOR = new Creator<VideoFromSearch>() {
        @Override
        public VideoFromSearch createFromParcel(Parcel in) {
            return new VideoFromSearch(in);
        }

        @Override
        public VideoFromSearch[] newArray(int size) {
            return new VideoFromSearch[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(channelId);
        parcel.writeString(channelTitle);
        parcel.writeString(description);
        parcel.writeString(publishedAt);
        parcel.writeString(title);
    }
}
