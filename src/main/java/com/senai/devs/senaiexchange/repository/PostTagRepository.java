package com.senai.devs.senaiexchange.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.devs.senaiexchange.entity.PostTag;
import com.senai.devs.senaiexchange.entity.PostTagId;

@Repository
public interface PostTagRepository extends JpaRepository<PostTag, PostTagId> {
    List<PostTag> findByPost_Id(Integer postId);
    List<PostTag> findByTag_Id(Long tagId);
    boolean existsByPost_IdAndTag_Id(Integer postId, Long tagId);
    void deleteByPost_IdAndTag_Id(Integer postId, Long tagId);
}