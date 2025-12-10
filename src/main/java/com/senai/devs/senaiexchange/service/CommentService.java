package com.senai.devs.senaiexchange.service;

import com.senai.devs.senaiexchange.dto.request.CommentRequest;
import com.senai.devs.senaiexchange.entity.User;
import com.senai.devs.senaiexchange.entity.Post;
import com.senai.devs.senaiexchange.repository.CommentRepository;
import com.senai.devs.senaiexchange.entity.Comment;
import com.senai.devs.senaiexchange.dto.response.CommentResponse;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import com.senai.devs.senaiexchange.repository.PostRepository;
import com.senai.devs.senaiexchange.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

	// Attributes
	private final CommentRepository commentRepository;
	private final UserRepository userRepository;
	private final PostRepository postRepository;

	// Constructor
	public CommentService(CommentRepository commentRepository,
						  UserRepository userRepository, PostRepository postRepository) {
		this.commentRepository = commentRepository;
		this.userRepository = userRepository;
		this.postRepository = postRepository;
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

	// List user comments
	public Optional<List<CommentResponse>> listUserComments(String username) {
		List<Comment> commentList = commentRepository.findAll();
		List<CommentResponse> commentResponseList = new ArrayList<>();

		for (Comment comment : commentList) {
			if (comment.getUser().getUsername().equals(username)) {
				commentResponseList.add(new CommentResponse(comment));
			}
		}
		return Optional.of(commentResponseList);
	}

	// Publish comment
	public String publishComment(CommentRequest commentRequest) {
		Optional<Post> postOptional = postRepository.findById(commentRequest.getPost_id());
		Optional<User> userOptional = userRepository.findById(commentRequest.getAuthor_id());

		Post post = postOptional.get();
		User user = userOptional.get();

		Comment newComment = new Comment(post, user,
				commentRequest.getContent(), LocalDateTime.now());
		commentRepository.save(newComment);
		return "Comentário publicado com sucesso!";
	}

	// Edit comment
	public String editComment(int id, CommentRequest editedComment) {
		Optional<Comment> commentOptional = commentRepository.findById(id);

		Comment comment = commentOptional.get();
		if (comment != null) {
			comment.setContent(editedComment.getContent());
			commentRepository.save(comment);
			return "Comentário atualizado!";
		} else {
			return "Comentário não encontrado!";
		}
	}

	// Delete comment
	public String deleteComment(int id) {
		if (commentRepository.existsById(id)) {
			commentRepository.deleteById(id);
			return "Comentário excluído com sucesso!";
		} else {
			return "Comentário não encontrado!";
		}
	}
}
