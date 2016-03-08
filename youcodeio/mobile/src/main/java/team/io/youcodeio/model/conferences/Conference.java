package team.io.youcodeio.model.conferences;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by stevenwatremez on 11/01/16.
 *
 */
public class Conference {

    /*****************************************************************
     * DATA
     ****************************************************************/
    @SerializedName("id")
    public String id;

    @SerializedName("name")
    public String name;

    @SerializedName("description")
    public String description;

    @SerializedName("sessions")
    public List<ConferenceSessions> sessionsList;

    /*****************************************************************
     * CONSTRUCTOR
     ****************************************************************/
    public Conference(@NonNull final String id,
                      @NonNull final String name,
                      @NonNull final String description,
                      @NonNull final List<ConferenceSessions> sessions) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.sessionsList = sessions;
    }

}
