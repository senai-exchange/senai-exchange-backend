package com.senai.devs.senaiexchange.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // ADICIONE ESTA IMPORT

import com.senai.devs.senaiexchange.dto.request.SearchHistoryRequest;
import com.senai.devs.senaiexchange.dto.response.SearchHistoryResponse;
import com.senai.devs.senaiexchange.entity.SearchHistory;
import com.senai.devs.senaiexchange.entity.User;
import com.senai.devs.senaiexchange.repository.SearchHistoryRepository;
import com.senai.devs.senaiexchange.repository.UserRepository;

@Service
public class SearchHistoryService {

	@Autowired
	private SearchHistoryRepository searchHistoryRepository;

	@Autowired
	private UserRepository userRepository;

	public SearchHistoryResponse createSearchHistory(SearchHistoryRequest request) {
		User user = userRepository.findById(request.getUserId())
				.orElseThrow(() -> new RuntimeException("User not found with id: " + request.getUserId()));

		SearchHistory searchHistory = new SearchHistory();
		searchHistory.setUser(user);
		searchHistory.setQueryText(request.getQueryText());
		searchHistory.setFilters(request.getFilters());
		searchHistory.setResultCount(request.getResultCount());

		SearchHistory savedHistory = searchHistoryRepository.save(searchHistory);
		return convertToResponse(savedHistory);
	}

	public List<SearchHistoryResponse> getSearchHistoryByUserId(Integer userId) {
		return searchHistoryRepository.findByUserIdOrderByCreatedAtDesc(userId).stream().map(this::convertToResponse)
				.collect(Collectors.toList());
	}

	public SearchHistoryResponse getSearchHistoryById(Integer id) {
		SearchHistory searchHistory = searchHistoryRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Search history not found with id: " + id));
		return convertToResponse(searchHistory);
	}

	public List<SearchHistoryResponse> searchByQueryText(String query) {
		return searchHistoryRepository.findByQueryTextContainingIgnoreCase(query).stream().map(this::convertToResponse)
				.collect(Collectors.toList());
	}

	public void deleteSearchHistory(Integer id) {
		if (!searchHistoryRepository.existsById(id)) {
			throw new RuntimeException("Search history not found with id: " + id);
		}
		searchHistoryRepository.deleteById(id);
	}

	@Transactional // ADICIONE ESTA ANOTAÇÃO
	public void deleteAllByUserId(Integer userId) {
		searchHistoryRepository.deleteByUserId(userId);
	}

	private SearchHistoryResponse convertToResponse(SearchHistory searchHistory) {
		return new SearchHistoryResponse(searchHistory.getId(), searchHistory.getUser().getId(),
				searchHistory.getUser().getUsername(), searchHistory.getUser().getDisplay_name(),
				searchHistory.getQueryText(), searchHistory.getFilters(), searchHistory.getResultCount(),
				searchHistory.getCreatedAt());
	}
}