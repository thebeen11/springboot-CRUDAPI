package com.app.models.repo;


import org.springframework.data.repository.CrudRepository;

import com.app.models.entity.Supplier;

public interface SupplierRepo extends CrudRepository<Supplier, Long>{

}
