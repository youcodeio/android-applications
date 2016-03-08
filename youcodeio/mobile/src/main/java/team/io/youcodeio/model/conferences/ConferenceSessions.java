package team.io.youcodeio.model.conferences;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

/**
 * Created by stevenwatremez on 08/03/16.
 *
 */
public class ConferenceSessions {

    /*****************************************************************
     * DATA
     ****************************************************************/
    @SerializedName("year")
    private String year;

    @SerializedName("link")
    private String link;

    /*****************************************************************
     * CONSTRUCTOR
     ****************************************************************/
    public ConferenceSessions(@NonNull final String year, @NonNull final String link) {
        this.year = year;
        this.link = link;
    }
}
