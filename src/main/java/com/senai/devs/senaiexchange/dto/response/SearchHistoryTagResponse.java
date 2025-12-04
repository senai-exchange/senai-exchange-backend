package com.senai.devs.senaiexchange.dto.response;

public class SearchHistoryTagResponse {

    private Long searchHistoryId;
    private Long tagId;

    public SearchHistoryTagResponse(Long searchHistoryId, Long tagId) {
        this.searchHistoryId = searchHistoryId;
        this.tagId = tagId;
    }

    public Long getSearchHistoryId() {
        return searchHistoryId;
    }

    public void setSearchHistoryId(Long searchHistoryId) {
        this.searchHistoryId = searchHistoryId;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }
}