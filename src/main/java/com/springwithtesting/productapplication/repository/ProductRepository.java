package com.springwithtesting.productapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springwithtesting.productapplication.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

}
