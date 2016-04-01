package team.io.youcodeio.model.channel;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

/**
 * Created by stevenwatremez on 15/01/16.
 *
 */
public class Channel {

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
}
