package team.io.youcodeio.model.search;

import com.google.gson.annotations.SerializedName;

/**
 * Created by stevenwatremez on 08/03/16.
 *
 */
public class Search {

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
}
