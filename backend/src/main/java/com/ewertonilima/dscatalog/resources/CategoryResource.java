package com.ewertonilima.dscatalog.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ewertonilima.dscatalog.entities.Category;
import com.ewertonilima.dscatalog.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService CategoryService;

	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
	List<Category> list = CategoryService.findAll();
		return ResponseEntity.ok().body(list);
	}

}
