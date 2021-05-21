package com.ewertonilima.dscatalog.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ewertonilima.dscatalog.dto.CategoryDTO;
import com.ewertonilima.dscatalog.entities.Category;
import com.ewertonilima.dscatalog.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll() {
		List<Category> list = categoryRepository.findAll();
		return list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());

	}

	@Transactional(readOnly = true)
	public CategoryDTO findById(Long id) {
		Optional<Category> obj = categoryRepository.findById(id);
		Category entity = obj.orElseThrow(() -> new EntityNotFoundException("Entity not found"));
		return new CategoryDTO(entity);
	}

	@Transactional
	public CategoryDTO post(CategoryDTO dto) {
		Category entity = new Category();
		entity.setName(dto.getName());
		entity = categoryRepository.save(entity);
		return new CategoryDTO(entity);
	}

}
