package com.senai.devs.senaiexchange.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Service;
import com.senai.devs.senaiexchange.dto.request.PostTagRequest;
import com.senai.devs.senaiexchange.dto.response.PostTagResponse;
import com.senai.devs.senaiexchange.entity.Post;
import com.senai.devs.senaiexchange.entity.PostTag;
import com.senai.devs.senaiexchange.entity.Tag;
import com.senai.devs.senaiexchange.repository.PostRepository;
import com.senai.devs.senaiexchange.repository.PostTagRepository;
import com.senai.devs.senaiexchange.repository.TagRepository;

@Service
public class PostTagService {

    private final PostTagRepository postTagRepository;
    private final PostRepository postRepository;
    private final TagRepository tagRepository;

    public PostTagService(PostTagRepository postTagRepository,
                          PostRepository postRepository,
                          TagRepository tagRepository) {
        this.postTagRepository = postTagRepository;
        this.postRepository = postRepository;
        this.tagRepository = tagRepository;
    }

    public PostTagResponse addTagToPost(PostTagRequest dto) {
        Post post = postRepository.findById(dto.getPost_id()).orElse(null);
        if (post == null) {
            throw new RuntimeException("Publicação não encontrada");
        }

        Tag tag = tagRepository.findById(dto.getTag_id()).orElse(null);
        if (tag == null) {
            throw new RuntimeException("Tag não encontrada");
        }


        PostTag pt = new PostTag(post, tag);
        postTagRepository.save(pt);
        return new PostTagResponse(pt);
    }

    public PostTagResponse removeTagFromPost(PostTagRequest dto) {
        Post post = postRepository.findById(dto.getPost_id()).orElse(null);
        if (post == null) {
            throw new RuntimeException("Publicação não encontrada");
        }

        Tag tag = tagRepository.findById(dto.getTag_id()).orElse(null);
        if (tag == null) {
            throw new RuntimeException("Tag não encontrada");
        }

        if (!postTagRepository.existsByPost_IdAndTag_Id(post.getId(), tag.getId())) {
            throw new RuntimeException("não encontrado");
        }

        postTagRepository.deleteByPost_IdAndTag_Id(post.getId(), tag.getId());
        PostTag pt = new PostTag(post, tag);
        return new PostTagResponse(pt);
    }



    public List<PostTagResponse> listByPost(Integer postId) {
        List<PostTag> list = postTagRepository.findByPost_Id(postId);
        List<PostTagResponse> resp = new ArrayList<>();
        for (PostTag pt : list) {
            resp.add(new PostTagResponse(pt));
        }
        return resp;
    }

    public List<PostTagResponse> listByTag(Long tagId) {
        List<PostTag> list = postTagRepository.findByTag_Id(tagId);
        List<PostTagResponse> resp = new ArrayList<>();
        for (PostTag pt : list) {
            resp.add(new PostTagResponse(pt));
        }
        return resp;
    }
}