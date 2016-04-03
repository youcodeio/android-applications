package team.io.youcodeio.model.search;

import com.google.gson.annotations.SerializedName;

/**
 * Created by stevenwatremez on 03/04/16.
 *
 */
public class VideoFromSearch {

    /*****************************************************************
     * DATA
     ****************************************************************/
    @SerializedName("channelId") public String channelId;
    @SerializedName("channelTitle") public String channelTitle;
    @SerializedName("description") public String description;
    @SerializedName("publishedAt") public String publishedAt;
    @SerializedName("title") public String title;

    /*****************************************************************
     * CONSTRUCTOR
     ****************************************************************/
    public VideoFromSearch() {}
}
