package com.xie.tmall.dao;

import com.xie.tmall.pojo.Product;
import com.xie.tmall.pojo.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductImageDAO extends JpaRepository<ProductImage,Integer>{
    public List<ProductImage> findByProductAndTypeOrderByIdDesc(Product product,String type);
}
