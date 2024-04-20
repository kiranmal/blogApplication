package com.kiran.blog.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter


public class CategoryDto {
	private Integer categoryId;
	
	@NotBlank
	@Size(min =4,message="Min size is of 4")
	private String categoryTitle;
	@NotBlank
	@Size(max = 10,message="Max size is of 10")
	private String categoryDescription;

}
