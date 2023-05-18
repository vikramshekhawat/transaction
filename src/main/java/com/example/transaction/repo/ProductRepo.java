package com.example.transaction.repo;


import com.example.transaction.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProductRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void saveProduct(Product product) {
       /* if (product.getId() == 6) {
            throw new RuntimeException();
        }*/

        String sql = "INSERT INTO PRODUCT VALUES(?,?,?,?)";
        Object[] args = {product.getId(), product.getName(), product.getPrice(), product.getQuantity()};
        jdbcTemplate.update(sql, args);

    }
}
