package com.mehmetberkan.logspherepro.service;

import com.mehmetberkan.logspherepro.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    public List<Product> getAllProduct() {
        return List.of(new Product());
    }

    public Product getByProductCode(String productCode) {
        return new Product();
    }

}
