package com.kiran.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kiran.blog.entities.Post;
import com.kiran.blog.entities.User;
import com.kiran.blog.entities.category;

public interface PostRepo extends JpaRepository<Post, Integer>{
	List<Post> findByUser(User user);
	List<Post> findByCategory(category category);

}
