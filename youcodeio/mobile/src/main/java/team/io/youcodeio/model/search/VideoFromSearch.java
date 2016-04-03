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
}
