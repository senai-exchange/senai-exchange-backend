package com.senai.devs.senaiexchange.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.devs.senaiexchange.entity.Draft;

@Repository
public interface DraftRepository extends JpaRepository<Draft, Integer>{

	List<Draft> findByTitleContainingIgnoreCase(String title);
	List<Draft> findByAuthorIdAndTag_Name(int authorId, String name);
	List<Draft> findAllByAuthorId(int authorId);
	List<Draft> findByAuthorId(int authorId);
	}