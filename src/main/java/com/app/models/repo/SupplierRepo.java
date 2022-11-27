package com.app.models.repo;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.app.models.entity.Supplier;

public interface SupplierRepo extends CrudRepository<Supplier, Long>{

    Supplier findByEmail(String email);

    List<Supplier> findByNameContains(String name);
}
