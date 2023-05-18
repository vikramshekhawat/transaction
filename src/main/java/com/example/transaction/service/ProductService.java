package com.example.transaction.service;


import com.example.transaction.Product;
import com.example.transaction.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    @Transactional
    public void saveProduct() {
        for (int i = 0; i < 10; i++) {
            Product product = new Product();
            product.setId(i);
            product.setName("abc");
            product.setPrice(34);
            product.setQuantity(2);
            productRepo.saveProduct(product);

        }
    }

}
