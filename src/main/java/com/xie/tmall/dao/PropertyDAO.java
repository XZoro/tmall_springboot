package com.xie.tmall.dao;

import com.xie.tmall.pojo.Category;
import com.xie.tmall.pojo.Property;
import com.xie.tmall.pojo.PropertyValue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyDAO extends JpaRepository<Property,Integer> {
    Page<Property> findByCategory(Category category, Pageable pageable);
    List<Property> findByCategory(Category category);
}
