package com.app.models.repo;

import org.springframework.data.repository.CrudRepository;

import com.app.models.entity.Category;

public interface CategoryRepo extends CrudRepository<Category, Long>{
    
}
