package com.senai.devs.senaiexchange.repository;

import com.senai.devs.senaiexchange.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract class TagRepository implements JpaRepository<Tag, Long> {

}