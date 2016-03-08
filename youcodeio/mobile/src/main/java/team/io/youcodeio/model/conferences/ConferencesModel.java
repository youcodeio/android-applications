package team.io.youcodeio.model.conferences;

import java.util.List;

/**
 * Created by stevenwatremez on 11/01/16.
 *
 */
public class ConferencesModel {

    /*****************************************************************
     * DATA
     ****************************************************************/
    private long id;
    private String mTitle;
    private String mSubtitle;
    private List<ConferenceSessions> mConferencesSessionsList;

    /*****************************************************************
     * CONSTRUCTOR
     ****************************************************************/
    public ConferencesModel() {
    }

    /*****************************************************************
     * GETTER
     ****************************************************************/
    public long getId() {
        return id;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getSubtitle() {
        return mSubtitle;
    }

    public List<ConferenceSessions> getConferencesSessions() {
        return mConferencesSessionsList;
    }

    /*****************************************************************
     * SETTER
     ****************************************************************/
    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String text) {
        this.mTitle = text;
    }

    public void setSubtitle(String subtitle) {
        this.mSubtitle = subtitle;
    }

    public void setConferencesSessions(List<ConferenceSessions> conferenceSessionsList) {
        mConferencesSessionsList = conferenceSessionsList;
    }

    public static class Builder {

        private ConferencesModel mConferencesModel;

        public Builder() {
            mConferencesModel = new ConferencesModel();
        }

        public Builder setTitle(String title) {
            mConferencesModel.mTitle = title;
            return this;
        }

        public Builder setSubtitle(String subtitle) {
            mConferencesModel.mSubtitle = subtitle;
            return this;
        }

        public Builder setConferenceSessions(List<ConferenceSessions> conferenceSessionsList) {
            mConferencesModel.mConferencesSessionsList = conferenceSessionsList;
            return this;
        }

        public ConferencesModel build() {
            return mConferencesModel;
        }

    }


}
