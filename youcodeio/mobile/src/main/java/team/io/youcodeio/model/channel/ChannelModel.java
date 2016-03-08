package team.io.youcodeio.model.channel;

import android.graphics.Bitmap;

/**
 * Created by stevenwatremez on 15/01/16.
 */
public class ChannelModel {


    /*****************************************************************
     * DATA
     ****************************************************************/
    private long id;
    private String mTitle;
    private String mDescription;
    private Bitmap mLogo;

    /*****************************************************************
     * CONSTRUCTOR
     ****************************************************************/
    public ChannelModel() {
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
        return mDescription;
    }

    public Bitmap getLogo() {
        return mLogo;
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
        this.mDescription = subtitle;
    }

    public void setLogo(Bitmap logo) {
        mLogo = logo;
    }

    public static class Builder {

        private ChannelModel mChannelModel;

        public Builder() {
            mChannelModel = new ChannelModel();
        }

        public Builder setTitle(String title) {
            mChannelModel.mTitle = title;
            return this;
        }

        public Builder setDescription(String description) {
            mChannelModel.mDescription = description;
            return this;
        }

        public Builder setLogo(Bitmap logo) {
            mChannelModel.mLogo = logo;
            return this;
        }

        public ChannelModel build() {
            return mChannelModel;
        }

    }

}
