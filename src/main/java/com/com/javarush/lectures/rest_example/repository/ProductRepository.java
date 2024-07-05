package com.com.javarush.lectures.rest_example.repository;

import com.com.javarush.lectures.rest_example.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCity(String city);
}