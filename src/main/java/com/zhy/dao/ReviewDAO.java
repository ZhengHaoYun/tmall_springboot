package com.zhy.dao;

import com.zhy.pojo.Product;
import com.zhy.pojo.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by HeyYun
 * Date 2019/10/7
 */
public interface ReviewDAO extends JpaRepository<Review, Integer> {
    List<Review> findByProductOrderByIdDesc(Product product);

    int countByProduct(Product product);
}
