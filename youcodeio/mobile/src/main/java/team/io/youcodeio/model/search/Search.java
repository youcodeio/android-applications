package team.io.youcodeio.model.search;

import android.support.annotation.NonNull;

/**
 * Created by stevenwatremez on 08/03/16.
 *
 */
public class Search {

    /*****************************************************************
     * DATA
     ****************************************************************/
    public String id;
    public String title;
    public String description;

    /*****************************************************************
     * CONSTRUCTOR
     ****************************************************************/
    public Search(@NonNull final String id,
                  @NonNull final String title,
                  @NonNull final String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }
}
