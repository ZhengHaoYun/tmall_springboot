package com.zhy.controller;

import com.zhy.pojo.Product;
import com.zhy.service.CategoryService;
import com.zhy.service.ProductService;
import com.zhy.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/categories/{cid}/products")
    public Page4Navigator<Product> list(@PathVariable("cid") int cid, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) {
        start = start < 0 ? 0 : start;

        return productService.list(cid, start, size, 5);
    }

    @GetMapping("/products/{id}")
    public Product get(@PathVariable("id") int id) {
        return productService.get(id);
    }

    @PostMapping("/products")
    public Object add(@RequestBody Product bean) {

        bean.setCreateDate(new Date());
        productService.add(bean);
        return bean;
    }

    @DeleteMapping("/products/{id}")
    public String delete(@PathVariable("id") int id) {
        productService.delete(id);
        return null;
    }

    @PutMapping("/products")
    public Object update(@RequestBody Product bean) {
        productService.update(bean);
        return bean;
    }
}