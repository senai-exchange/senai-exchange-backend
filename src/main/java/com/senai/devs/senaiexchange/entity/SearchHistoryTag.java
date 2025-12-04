package com.senai.devs.senaiexchange.entity;

import jakarta.persistence.*;

@Entity
public class SearchHistoryTag {

    @Id
    @Column(name = "search_history_id", nullable = false)
    private Long searchHistoryId;

    @Id
    @Column(name = "tag_id", nullable = false)
    private Long tagId;

    public SearchHistoryTag() {

    }

    public SearchHistoryTag(Long searchHistoryId, Long tagId) {
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