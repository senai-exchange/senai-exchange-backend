package com.senai.devs.senaiexchange.service;

import com.senai.devs.senaiexchange.dto.request.PostRequest;
import com.senai.devs.senaiexchange.dto.response.PostResponse;
import com.senai.devs.senaiexchange.entity.Post;
import com.senai.devs.senaiexchange.entity.User;
import com.senai.devs.senaiexchange.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository repository;
    private final UserRepository userRepository;
    private final TagRepository tagRepository;

    public PostService(PostRepository repository, UserRepository userRepository, TagRepository tagRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.tagRepository = tagRepository;
    }


    public PostResponse create(PostRequest dto) {
        User author = userRepository.findByUsernameOrId(dto.getAuthor_id());
        if (author == null) {
            throw new RuntimeException("Autor não encontrado");
        }

        Post post = new Post();
        post.setUser(author);
        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        post.setStatus(dto.getStatus != null ? dto.getStatus() : false);
        post.setPublished_at(dto.getPublished_at());
        post.setCreated_at(LocalDateTime.now());

        // Associações de tags
        if (dto.getTag_ids() != null && !dto.getTag_ids().isEmpty()) {
            HashSet<Tag> set = new HashSet<>();
            for (Long tagId : dto.getTag_ids()) {
                Tag tag = tagRepository.findById(tagId).orElse(null);
                if (tag != null) {
                    set.add(tag);
                }
            }
            post.setTags(set);
        }

        postRepository.save(post);
        return new PostResponse(post);
    }

    // Find all
    public List<PostResponse> findAll() {
        List<Post> posts = postRepository.findAll();
        List<PostResponse> responses = new ArrayList<>();
        for (Post post : posts) {
            responses.add(new PostResponse(post));
        }
        return responses;
    }

    // Find by id
    public PostResponse findById(int id) {
        Post post = postRepository.findById(id).orElse(null);
        if (post == null) {
            throw new RuntimeException("Publicação não encontrada");
        }
        return new PostResponse(post);
    }

    // Update
    public PostResponse update(int id, PostRequest dto) {
        Post post = postRepository.findById(id).orElse(null);
        if (post == null) {
            throw new RuntimeException("Publicação não encontrada");
        }

        if (dto.getTitle() != null) post.setTitle(dto.getTitle());
        if (dto.getContent() != null) post.setContent(dto.getContent());
        if (dto.getStatus() != null) post.setStatus(dto.getStatus());
        if (dto.getPublished_at() != null) post.setPublished_at(dto.getPublished_at());

        // Atualiza associações de tags (substitui conjunto)
        if (dto.getTag_ids() != null) {
            HashSet<Tag> set = new HashSet<>();
            for (Long tagId : dto.getTag_ids()) {
                Tag tag = tagRepository.findById(tagId).orElse(null);
                if (tag != null) {
                    set.add(tag);
                }
            }
            post.setTags(set);
        }

        postRepository.save(post);
        return new PostResponse(post);
    }

    // Delete
    public boolean delete(int id) {
        if (!postRepository.existsById(id)) {
            return false;
        }
        postRepository.deleteById(id);
        return true;
    }
}