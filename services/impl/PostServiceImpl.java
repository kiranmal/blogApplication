package com.kiran.blog.services.impl;




import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kiran.blog.entities.Post;
import com.kiran.blog.entities.User;
import com.kiran.blog.entities.category;
import com.kiran.blog.exception.ResourceNotFoundException;
import com.kiran.blog.payloads.PostDto;
import com.kiran.blog.repositories.CategoryRepo;
import com.kiran.blog.repositories.PostRepo;
import com.kiran.blog.repositories.UserRepo;
import com.kiran.blog.services.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepo postRepo;
	@Autowired 
	private ModelMapper modelMapper;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public PostDto createPost(PostDto postDto,Integer userId,Integer categoryId) {
		
		User user=this.userRepo.findById(userId).
				orElseThrow(()->new ResourceNotFoundException("User","User Id",userId));
		category category=this.categoryRepo.findById(categoryId)
				.orElseThrow(()-> new ResourceNotFoundException("category", "catgeroy Id", categoryId));
		Post post=this.modelMapper.map(postDto, Post.class);
		post.setImageName("default.png");
		post.setAddedDate(new Date());
		post.setUser(user);
		post.setCategory(category);
		
		Post newPost=this.postRepo.save(post);
		
		
		return this.modelMapper.map(newPost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
	Post post=this.postRepo.findById(postId)
			.orElseThrow(()->new ResourceNotFoundException("Post", "Post id", postId));
	post.setTitle(postDto.getTitle());
	post.setContent(post.getContent());
	post.setImageName(postDto.getImageName());
	Post updatedPost=this.postRepo.save(post);
	
		return this.modelMapper.map(updatedPost,PostDto.class);
	}

	@Override
	public void deletePost(Integer postId) {
		Post post=this.postRepo.findById(postId)
				.orElseThrow(()-> new ResourceNotFoundException("Post", "post id", postId));
		
		

	}

	@Override
	public PostDto getPostById(Integer postId) {
		Post post = this.postRepo.findById(postId)
		.orElseThrow(()->new ResourceNotFoundException("Post", "Post Id", postId));
		return this.modelMapper.map(post,PostDto.class);
	}

	@Override
	public List<PostDto> getAllPost() {
		//for getting all posts
		List<Post> allPosts = this.postRepo.findAll();
		List<PostDto> postDtos = allPosts.stream().map((post)-> this.modelMapper.map(post, PostDto.class))
		.collect(Collectors.toList());
		return postDtos;
	}

	@Override
	public List<PostDto> getPostsByCategory(Integer categoryId) {
		category cat=this.categoryRepo.findById(categoryId)
				.orElseThrow(()->new ResourceNotFoundException("Category", "Category Id", categoryId));
		List<Post> posts = this.postRepo.findByCategory(cat);
		List<PostDto> postDtos = posts.stream().map((post)->this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}

	@Override
	public List<PostDto> getPostsByUser(Integer userId) {
		User user = this.userRepo.findById(userId)
		.orElseThrow(()->new ResourceNotFoundException("User","user Id",userId));
	List<Post> posts = this.postRepo.findByUser(user);
	List<PostDto> postDtos = posts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
	
		return postDtos;
	}

	@Override
	public List<Post> searchPosts(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
