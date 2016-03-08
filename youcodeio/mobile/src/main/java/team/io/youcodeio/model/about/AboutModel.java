package team.io.youcodeio.model.about;

import java.util.Map;

/**
 * Created by stevenwatremez on 15/01/16.
 */
public class AboutModel {

    /*****************************************************************
     * DATA
     ****************************************************************/
    private long id;
    private String mName;
    private String mSkills;
    private String mDescription;
    private Map<String, String> mSocialNetworkLink;

    /*****************************************************************
     * CONSTRUCTOR
     ****************************************************************/
    public AboutModel() {
    }

    /*****************************************************************
     * GETTER
     ****************************************************************/
    public long getId() {
        return id;
    }

    public String getName() {
        return mName;
    }

    public String getSkills() {
        return mSkills;
    }

    public String getDescription() {
        return mDescription;
    }

    public Map<String, String> getSocialNetworkLink() {
        return mSocialNetworkLink;
    }

    /*****************************************************************
     * SETTER
     ****************************************************************/
    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String text) {
        this.mName = text;
    }

    public void setSkills(String skills) {
        this.mSkills = skills;
    }

    public void setSubtitle(String subtitle) {
        this.mDescription = subtitle;
    }

    public void setSocialNetworkLink(Map<String, String> socialNetworkLink) {
        mSocialNetworkLink = socialNetworkLink;
    }

    public static class Builder {

        private AboutModel mAboutModel;

        public Builder() {
            mAboutModel = new AboutModel();
        }

        public Builder setName(String name) {
            mAboutModel.mName = name;
            return this;
        }

        public Builder setSkills(String skills) {
            mAboutModel.mSkills = skills;
            return this;
        }

        public Builder setDescription(String description) {
            mAboutModel.mDescription = description;
            return this;
        }

        public Builder setSocialNetworkLink(Map<String, String> socialNetworkLink) {
            mAboutModel.mSocialNetworkLink = socialNetworkLink;
            return this;
        }

        public AboutModel build() {
            return mAboutModel;
        }

    }

}
