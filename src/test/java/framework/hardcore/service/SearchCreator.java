package framework.hardcore.service;

import framework.hardcore.model.Search;

public class SearchCreator {
    public static final String TEST_DATA_SEARCH_QUERY = "Google Cloud Platform Pricing Calculator";


    public static Search withQueryFromProperty(){
        return new Search(TEST_DATA_SEARCH_QUERY);
    }

}