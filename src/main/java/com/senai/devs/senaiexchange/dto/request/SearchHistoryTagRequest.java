package com.senai.devs.senaiexchange.dto.request;

import jakarta.validation.constraints.NotNull;

public class SearchHistoryTagRequest {

    @NotNull
    private Long searchHistoryId;
    @NotNull
    private Long tagId;

    public @NotNull Long getSearchHistoryId() {
        return searchHistoryId;
    }

    public void setSearchHistoryId(@NotNull Long searchHistoryId) {
        this.searchHistoryId = searchHistoryId;
    }

    public @NotNull Long getTagId() {
        return tagId;
    }

    public void setTagId(@NotNull Long tagId) {
        this.tagId = tagId;
    }
}