package com.senai.devs.senaiexchange.repository;

import com.senai.devs.senaiexchange.entity.Comment;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
