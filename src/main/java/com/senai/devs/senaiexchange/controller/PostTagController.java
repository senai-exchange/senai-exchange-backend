package com.senai.devs.senaiexchange.controller;

import com.senai.devs.senaiexchange.dto.request.PostTagRequest;
import com.senai.devs.senaiexchange.dto.response.PostTagResponse;
import com.senai.devs.senaiexchange.service.PostTagService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts/tags")
public class PostTagController {

    private final PostTagService postTagService;

    public PostTagController(PostTagService postTagService) {
        this.postTagService = postTagService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> addTagToPost(@RequestBody PostTagRequest dto) {
        try {
            PostTagResponse resp = postTagService.addTagToPost(dto);
            return ResponseEntity.ok(resp);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/remove")
    public ResponseEntity<?> removeTagFromPost(@RequestBody PostTagRequest dto) {
        try {
            PostTagResponse resp = postTagService.removeTagFromPost(dto);
            return ResponseEntity.ok(resp);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/by-post/{postId}")
    public ResponseEntity<?> listByPost(@PathVariable Integer postId) {
        try {
            List<PostTagResponse> list = postTagService.listByPost(postId);
            return ResponseEntity.ok(list);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/by-tag/{tagId}")
    public ResponseEntity<?> listByTag(@PathVariable Long tagId) {
        try {
            List<PostTagResponse> list = postTagService.listByTag(tagId);
            return ResponseEntity.ok(list);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}