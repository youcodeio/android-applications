package team.io.youcodeio.model.channel;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

/**
 * Created by stevenwatremez on 15/01/16.
 *
 */
public class Channel implements Parcelable {

    /*****************************************************************
     * DATA
     ****************************************************************/
    @SerializedName("id") public Integer id;
    @SerializedName("name") public String title;
    @SerializedName("ytid") public String youtubeId;
    @SerializedName("isTuts") public boolean isTuts;

    /*****************************************************************
     * CONSTRUCTOR
     ****************************************************************/
    public Channel(@NonNull final Integer id,
                   @NonNull final String title,
                   @NonNull final String youtubeId,
                   final boolean isTuts) {
        this.id = id;
        this.title = title;
        this.youtubeId = youtubeId;
        this.isTuts = isTuts;
    }

    /*****************************************************************
     * PARCELABLE
     ****************************************************************/
    protected Channel(Parcel in) {
        title = in.readString();
        youtubeId = in.readString();
        isTuts = in.readByte() != 0;
    }

    public static final Creator<Channel> CREATOR = new Creator<Channel>() {
        @Override
        public Channel createFromParcel(Parcel in) {
            return new Channel(in);
        }

        @Override
        public Channel[] newArray(int size) {
            return new Channel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(youtubeId);
        parcel.writeByte((byte) (isTuts ? 1 : 0));
    }
}
