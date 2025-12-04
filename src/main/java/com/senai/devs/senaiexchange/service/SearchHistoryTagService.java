package com.senai.devs.senaiexchange.service;

import com.senai.devs.senaiexchange.dto.request.SearchHistoryTagRequest;
import com.senai.devs.senaiexchange.dto.response.SearchHistoryTagResponse;
import com.senai.devs.senaiexchange.entity.SearchHistoryTag;
import com.senai.devs.senaiexchange.repository.SearchHistoryTagRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchHistoryTagService {

    private final SearchHistoryTagRepository repository;

    public SearchHistoryTagService(SearchHistoryTagRepository repository) {
        this.repository = repository;
    }

    public SearchHistoryTagResponse criar(SearchHistoryTagRequest dto) {
        SearchHistoryTag sht = new SearchHistoryTag(dto.getSearchHistoryId(), dto.getTagId());
        repository.save(sht);
        return new SearchHistoryTagResponse(sht.getSearchHistoryId(), sht.getTagId());
    }

    public List<SearchHistoryTagResponse> listarTodos() {
        return repository.findAll().stream()
                .map(sht -> new SearchHistoryTagResponse(sht.getSearchHistoryId(), sht.getTagId()))
                .collect(Collectors.toList());
    }
}
