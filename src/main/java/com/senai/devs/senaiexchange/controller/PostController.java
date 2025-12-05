package com.senai.devs.senaiexchange.controller;

import com.senai.devs.senaiexchange.dto.request.PostRequest;
import com.senai.devs.senaiexchange.dto.response.PostResponse;
import com.senai.devs.senaiexchange.entity.Post;
import com.senai.devs.senaiexchange.repository.PostRepository;
import com.senai.devs.senaiexchange.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private PostService postService;
    private final PostTagRepository postTagRepository;

    public PostController(PostService postService, PostTagService) {
        this.postService = postService;
        this.postTagService = postTagService;

    }

    // CRUD
    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@Valid @RequestBody PostRequest dto) {
        try {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(postService.create(dto));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping(value = "/all")
    public List<PostResponse> findAll() {
        return postService.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(postService.findById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody PostRequest dto) {
        try {
            return ResponseEntity.ok(postService.update(id, dto));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        boolean deleted = postService.delete(id);
        if (deleted) {
            return ResponseEntity.ok("Publicação deletada com sucesso!");
        }
        return ResponseEntity.notFound().build();
    }

    // Associação Post ↔ Tag
    @PostMapping(value = "/tags/add")
    public ResponseEntity<?> addTagToPost(@RequestBody PostTagRequest dto) {
        try {
            PostTagResponse resp = postTagService.addTagToPost(dto);
            return ResponseEntity.ok(resp);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/tags/remove")
    public ResponseEntity<?> removeTagFromPost(@RequestBody PostTagRequest dto) {
        try {
            PostTagResponse resp = postTagService.removeTagFromPost(dto);
            return ResponseEntity.ok(resp);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
