package com.example.transaction;

import com.example.transaction.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TransactionApplication implements CommandLineRunner {
    @Autowired
    ProductService productService;

    public static void main(String[] args) {
        SpringApplication.run(TransactionApplication.class, args);
		System.out.println("Updated by In feature");


    }

    @Override
    public void run(String... args) throws Exception {
        productService.saveProduct();
    }
}
