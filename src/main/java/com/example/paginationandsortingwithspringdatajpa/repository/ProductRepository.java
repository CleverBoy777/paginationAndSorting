package com.example.paginationandsortingwithspringdatajpa.repository;

import com.example.paginationandsortingwithspringdatajpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
}
