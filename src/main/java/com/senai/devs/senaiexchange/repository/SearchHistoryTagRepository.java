package com.senai.devs.senaiexchange.repository;

import com.senai.devs.senaiexchange.entity.SearchHistoryTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchHistoryTagRepository extends JpaRepository<SearchHistoryTag, Long> {
}
