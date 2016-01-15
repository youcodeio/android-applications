package team.io.youcodeio.model;

import java.util.List;
import java.util.Map;

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
    private Map<String, String> mConferencesYear;

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

    public Map<String, String> getConferencesYear() {
        return mConferencesYear;
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

    public void setConferencesYear(Map<String, String> conferencesYear) {
        mConferencesYear = conferencesYear;
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

        public Builder setConferencesYear(Map<String, String> conferencesYear) {
            mConferencesModel.mConferencesYear= conferencesYear;
            return this;
        }

        public ConferencesModel build() {
            return mConferencesModel;
        }

    }


}
