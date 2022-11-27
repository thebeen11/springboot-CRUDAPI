package com.app.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.models.entity.Product;
import com.app.models.entity.Supplier;
import com.app.models.repo.ProductRepo;
import com.app.models.repo.SupplierRepo;

import java.util.List;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private SupplierRepo supplierRepo;

    public Product save(Product product) {
        return productRepo.save(product);
    }

    public Product findProduct(Long id) {
        Optional<Product> product = productRepo.findById(id);

        if (!product.isPresent()) {
            return null;
        }
        return product.get();
    }

    public Iterable<Product> findAll() {
        return productRepo.findAll();
    }

    public void removeOne(Long id) {
        productRepo.deleteById(id);
    }

    public List<Product> findByName(String name) {
        return productRepo.findProductByName("%" + name + "%");
    }

    public List<Product> findBySupplier(Long id) {
        return productRepo.findProductBySuppliersId(id);
    }

    public void addSupplier(Supplier supplier, Long productId) {
        Product product = findProduct(productId);
        if (product == null) {
            throw new RuntimeException("Product with Id: " + productId + "not Found");
        }

        Optional<Supplier> suppilerFromDB = supplierRepo.findById(supplier.getId());

        if (suppilerFromDB.isPresent()) {
            product.getSuppliers().add(suppilerFromDB.get());
            save(product);
        }

    }

    public List<Product> finndByCategory(Long id) {
        return productRepo.findProductByCategoryId(id);
    }
}
