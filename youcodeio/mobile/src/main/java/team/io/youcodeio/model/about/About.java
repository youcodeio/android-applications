package team.io.youcodeio.model.about;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by stevenwatremez on 15/01/16.
 *
 */
public class About {

    /*****************************************************************
     * DATA
     ****************************************************************/
    public String id;
    public String name;
    public String skills;
    public String description;
    public List<SocialNetwork> socialNetworkList;

    /*****************************************************************
     * CONSTRUCTOR
     ****************************************************************/
    public About(@NonNull final String id,
                 @NonNull final String name,
                 @NonNull final String skills,
                 @NonNull final String description,
                 @NonNull final List<SocialNetwork> socialNetworkList) {
        this.id = id;
        this.name = name;
        this.skills = skills;
        this.description = description;
        this.socialNetworkList = socialNetworkList;
    }
}
