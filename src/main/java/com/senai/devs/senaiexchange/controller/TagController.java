package com.senai.devs.senaiexchange.controller;

import com.senai.devs.senaiexchange.dto.request.TagRequest;
import com.senai.devs.senaiexchange.dto.response.TagResponse;
import com.senai.devs.senaiexchange.service.TagService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tag")
public class TagController {

    private  final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @PostMapping
    public ResponseEntity<TagResponse> create(@RequestBody TagRequest dto) {
        return ResponseEntity.ok(tagService.createTag(dto));
    }

    @GetMapping ("/{id}")
    public ResponseEntity<?> search(@PathVariable long id) {
        try {
            TagResponse tag = tagService.searchId(id);
            return ResponseEntity.ok(tag);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody TagResponse dto) {
        try {
            TagResponse tagAtualizada = tagService.update(id, dto);
            return ResponseEntity.ok(tagAtualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        boolean deletado = tagService.deleted(id);

        if (deletado) {
            return ResponseEntity.ok("Tag deletada com sucesso!");
        }

        return ResponseEntity.notFound().build();
    }
}