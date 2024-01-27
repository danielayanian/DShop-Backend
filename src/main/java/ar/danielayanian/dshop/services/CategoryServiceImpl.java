package ar.danielayanian.dshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.danielayanian.dshop.entities.Category;
import ar.danielayanian.dshop.repositories.CategoryRepository;
import ar.danielayanian.dshop.repositories.ProductRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
    private CategoryRepository categoryRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Category> findAllCategorias(){
		return categoryRepository.findAll();
	}
	
}
