package com.kiran.blog.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import com.kiran.blog.entities.category;



public interface CategoryRepo extends JpaRepository<category,Integer>{

	
	
	
}