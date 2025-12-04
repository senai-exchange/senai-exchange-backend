package com.senai.devs.senaiexchange.controller;

import com.senai.devs.senaiexchange.dto.request.SearchHistoryTagRequest;
import com.senai.devs.senaiexchange.dto.response.SearchHistoryTagResponse;
import com.senai.devs.senaiexchange.service.SearchHistoryTagService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/search-history-tags")
public class SearchHistoryTagController {

    private final SearchHistoryTagService service;

    public SearchHistoryTagController(SearchHistoryTagService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SearchHistoryTagResponse> criar(@RequestBody SearchHistoryTagRequest dto) {
        return ResponseEntity.ok(service.criar(dto));
    }

    @GetMapping
    public ResponseEntity<List<SearchHistoryTagResponse>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }
}
