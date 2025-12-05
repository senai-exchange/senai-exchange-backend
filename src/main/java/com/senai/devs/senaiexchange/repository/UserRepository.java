package com.senai.devs.senaiexchange.repository;

import com.senai.devs.senaiexchange.entity.User;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String username);

    User findByUsernameOrId(int authorId);
}