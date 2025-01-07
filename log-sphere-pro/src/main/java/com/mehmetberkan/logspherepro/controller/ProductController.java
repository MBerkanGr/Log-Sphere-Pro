package com.mehmetberkan.logspherepro.controller;

import com.mehmetberkan.logspherepro.model.Product;
import com.mehmetberkan.logspherepro.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/products")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct() {

        logger.info("Started GetAll Method");
        return ResponseEntity.ok(productService.getAllProduct());
    }

    @GetMapping("/{productCode}")
    public ResponseEntity<Product> getByProductCode(@RequestParam("productCode") String productCode) {

        logger.info("Started GetByProductCode, Product Code : {}", productCode);
        return ResponseEntity.ok(productService.getByProductCode(productCode));
    }

}
