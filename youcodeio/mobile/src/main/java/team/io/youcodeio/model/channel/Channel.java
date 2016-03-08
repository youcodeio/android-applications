package team.io.youcodeio.model.channel;

import android.support.annotation.NonNull;

/**
 * Created by stevenwatremez on 15/01/16.
 *
 */
public class Channel {

    /*****************************************************************
     * DATA
     ****************************************************************/
    public String id;
    public String title;
    public String description;

    /*****************************************************************
     * CONSTRUCTOR
     ****************************************************************/
    public Channel(@NonNull final String id,
                   @NonNull final String title,
                   @NonNull final String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }
}
