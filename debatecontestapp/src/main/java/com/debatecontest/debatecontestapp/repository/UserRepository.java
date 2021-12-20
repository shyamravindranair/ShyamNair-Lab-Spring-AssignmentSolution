package com.debatecontest.debatecontestapp.repository;

import com.debatecontest.debatecontestapp.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.username = ?1")
    User getUserByUsername(String username);

}
