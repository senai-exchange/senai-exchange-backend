package com.senai.devs.senaiexchange.controller;

import com.senai.devs.senaiexchange.dto.request.SearchHistoryRequest;
import com.senai.devs.senaiexchange.dto.response.SearchHistoryResponse;
import com.senai.devs.senaiexchange.service.SearchHistoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/search-history")
public class SearchHistoryController {

    @Autowired
    private SearchHistoryService searchHistoryService;

    @PostMapping
    public ResponseEntity<SearchHistoryResponse> createSearchHistory(
            @Valid @RequestBody SearchHistoryRequest request) {
        SearchHistoryResponse response = searchHistoryService.createSearchHistory(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SearchHistoryResponse>> getSearchHistoryByUser(
            @PathVariable Integer userId) {
        List<SearchHistoryResponse> history = searchHistoryService.getSearchHistoryByUserId(userId);
        return ResponseEntity.ok(history);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SearchHistoryResponse> getSearchHistoryById(
            @PathVariable Integer id) {
        SearchHistoryResponse history = searchHistoryService.getSearchHistoryById(id);
        return ResponseEntity.ok(history);
    }

    @GetMapping("/search")
    public ResponseEntity<List<SearchHistoryResponse>> searchByQuery(
            @RequestParam String query) {
        List<SearchHistoryResponse> results = searchHistoryService.searchByQueryText(query);
        return ResponseEntity.ok(results);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSearchHistory(
            @PathVariable Integer id) {
        searchHistoryService.deleteSearchHistory(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<Void> deleteAllByUser(
            @PathVariable Integer userId) {
        searchHistoryService.deleteAllByUserId(userId);
        return ResponseEntity.noContent().build();
    }
}