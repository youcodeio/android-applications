package team.io.youcodeio.model.search;

/**
 * Created by stevenwatremez on 08/03/16.
 *
 */
public class SearchModel {

    /*****************************************************************
     * DATA
     ****************************************************************/
    private String searchId;
    private String searchVideoTitle;
    private String searchVideoDescription;

    /*****************************************************************
     * CONSTRUCTOR
     ****************************************************************/
    public SearchModel() {}

    /*****************************************************************
     * GETTER
     ****************************************************************/
    public String getSearchId() {
        return searchId;
    }

    public String getSearchVideoTitle() {
        return searchVideoTitle;
    }

    public String getSearchVideoDescription() {
        return searchVideoDescription;
    }

    /*****************************************************************
     * INNER CLASS
     ****************************************************************/
    public static class Builder {

        private SearchModel mSearchModel;

        public Builder() {
            mSearchModel = new SearchModel();
        }

        public Builder setTitle(String title) {
            mSearchModel.searchVideoTitle = title;
            return this;
        }

        public Builder setDescription(String description) {
            mSearchModel.searchVideoDescription = description;
            return this;
        }

        public SearchModel build() {
            return mSearchModel;
        }

    }
}
