package com.zhy.dao;

import com.zhy.pojo.Product;
import com.zhy.pojo.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
 
public interface ProductImageDAO extends JpaRepository<ProductImage,Integer>{
    public List<ProductImage> findByProductAndTypeOrderByIdDesc(Product product, String type);
     
}