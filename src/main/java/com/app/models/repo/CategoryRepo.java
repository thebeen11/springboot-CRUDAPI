package com.app.models.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.models.entity.Category;

public interface CategoryRepo extends PagingAndSortingRepository<Category, Long>{
    Page<Category> findByNameContains(String name, Pageable pageable);
}
