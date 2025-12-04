package com.senai.devs.senaiexchange.repository;

import com.senai.devs.senaiexchange.entity.SearchHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchHistoryRepository extends JpaRepository<SearchHistory, Integer> {

	List<SearchHistory> findByUserId(Integer userId);

	List<SearchHistory> findByUserIdOrderByCreatedAtDesc(Integer userId);

	List<SearchHistory> findByQueryTextContainingIgnoreCase(String queryText);

	void deleteByUserId(Integer userId);
}