package com.senai.devs.senaiexchange.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.senai.devs.senaiexchange.dto.request.DraftRequest;
import com.senai.devs.senaiexchange.dto.response.DraftResponse;
import com.senai.devs.senaiexchange.dto.response.DraftResponseResume;
import com.senai.devs.senaiexchange.service.DraftService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("draft")
public class DraftController {

    private final DraftService draftService;

    public DraftController(DraftService draftService) {
        this.draftService = draftService;
    }

    // CREATE
    @PostMapping("create")
    public ResponseEntity<DraftResponse> create(@Valid @RequestBody DraftRequest draftRequest) {
        DraftResponse response = draftService.create(draftRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // DELETE BY ID
    @DeleteMapping("delete/{authorId}/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int authorId, @PathVariable int id) {
        draftService.deleteById(id, authorId);
        return ResponseEntity.ok("Draft deleted successfully.");
    }

    // DELETE ALL 
    @DeleteMapping("delete/all")
    public ResponseEntity<Void> deleteAll() {
        draftService.deleteAll();
        return ResponseEntity.noContent().build();
    }

    // DELETE ALL BY AUTHOR
    @DeleteMapping("delete/all/author")
    public ResponseEntity<Void> deleteAllByAuthor(@RequestParam int authorId) {
        draftService.deleteAllByAuthor(authorId);
        return ResponseEntity.noContent().build();
    }

    // UPDATE 
    @PutMapping("update/{authorId}/{id}")
    public ResponseEntity<DraftResponse> update(@PathVariable int id, @PathVariable  int authorId,  @Valid @RequestBody DraftRequest draftRequest) {
        DraftResponse response = draftService.update(id, authorId, draftRequest);
        return ResponseEntity.ok(response);
    }

    // FIND BY ID 
    @GetMapping("search/{authorId}/{id}")
    public ResponseEntity<DraftResponse> findById( @PathVariable int authorId, @PathVariable int id) {

        DraftResponse response = draftService.findById(id, authorId);
        return ResponseEntity.ok(response);
    }

    // LIST ALL 
    @GetMapping("list")
    public ResponseEntity<List<DraftResponse>> list() {
        return ResponseEntity.ok(draftService.findAll());
    }

    // LIST ALL BY AUTHOR 
    @GetMapping("author/{authorId}/list")
    public ResponseEntity<List<DraftResponseResume>> listByAuthor(@PathVariable int authorId) {
        List<DraftResponseResume> drafts = draftService.findAllByAuthorId(authorId);
        return ResponseEntity.ok(drafts);
    }
}
