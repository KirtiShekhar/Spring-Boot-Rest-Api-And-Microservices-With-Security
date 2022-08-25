package com.springboot.restapisample.repository;

import com.springboot.restapisample.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Products,Long>
{
    Products findByProductName(String productName);
}