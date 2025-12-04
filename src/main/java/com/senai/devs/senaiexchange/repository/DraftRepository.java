package com.senai.devs.senaiexchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.devs.senaiexchange.entity.Draft;

public class DraftRepository {

	public interface TodoRepository extends JpaRepository<Draft, Integer> {
		
		Draft findByDraftTitle(String title);
		
	}
}