package com.app.models.repo;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.app.models.entity.Product;

public interface ProductRepo extends CrudRepository<Product, Long>{

    @Query("SELECT p FROM Product p WHERE p.name LIKE :name")
    public List<Product> findProductByName(@PathParam("name") String name);

    // @Query("SELECT p FROM Product p WHERE p.suppliers = :id")
    public List<Product> findProductBySuppliersId(Long id);
}
