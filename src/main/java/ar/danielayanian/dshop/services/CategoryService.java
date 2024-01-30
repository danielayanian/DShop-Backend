package ar.danielayanian.dshop.services;

import java.util.List;

import ar.danielayanian.dshop.entities.Category;

public interface CategoryService {

	public List<Category> findAllCategorias();
	
	public Category findById(int id);
	
}
