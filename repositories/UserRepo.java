package com.kiran.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kiran.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
