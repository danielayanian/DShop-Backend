package ar.danielayanian.dshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.danielayanian.dshop.entities.Category;
import ar.danielayanian.dshop.entities.Product;
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
	
	@Override
	@Transactional(readOnly = true)
	public Category findById(int id) {
		Optional<Category> op = categoryRepository.findById(id);
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}
	
}
