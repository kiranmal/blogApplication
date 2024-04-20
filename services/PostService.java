package com.kiran.blog.services;

import java.util.List;

import com.kiran.blog.entities.Post;
import com.kiran.blog.payloads.PostDto;

public interface PostService {
	  //create
	
	PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	
	//update
	
	
	Post updatePost(PostDto postDto,Integer postId);
	//delete
	
	void deletePost(Integer postId);
	
	
	
	//getsinglepost
	
	
	Post getPostById(Integer postId);
	
	
	//getallpost
	List<Post> getAllPost();
	
	//get all post by category
	
	List<PostDto> getPostsByCategory(Integer categoryId);
	
	//get all posts by user
	
	List<PostDto> getPostsByUser(Integer userId);
	
	//search posts
	
	List<Post> searchPosts(String keyword);
}
