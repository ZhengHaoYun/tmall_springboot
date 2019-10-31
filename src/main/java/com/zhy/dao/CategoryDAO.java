package com.zhy.dao;

import com.zhy.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;
 
public interface CategoryDAO extends JpaRepository<Category,Integer>{
 
}