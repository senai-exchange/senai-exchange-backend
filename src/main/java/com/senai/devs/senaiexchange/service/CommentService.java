package com.senai.devs.senaiexchange.service;

import com.senai.devs.senaiexchange.repository.CommentRepository;
import com.senai.devs.senaiexchange.entity.Comment;
import com.senai.devs.senaiexchange.dto.response.CommentResponse;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class CommentService {

	// Attribute
	private final CommentRepository commentRepository;

	// Constructor
	public CommentService(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}

	// List all comments
	public List<CommentResponse> listAllComments() {
		List<Comment> commentList = commentRepository.findAll();
		List<CommentResponse> commentResponseList = new ArrayList<>();

		for (Comment comment : commentList) {
			commentResponseList.add(new CommentResponse(comment));
		}
		return commentResponseList;
	}
}
