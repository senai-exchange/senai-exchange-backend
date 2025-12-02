package com.senai.devs.senaiexchange.repository;

import com.senai.devs.senaiexchange.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {

Post findById(int id);

}