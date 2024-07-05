package com.com.javarush.lectures.rest_example.controller;

import com.com.javarush.lectures.rest_example.dto.ProductAvailabilityDTO;
import com.com.javarush.lectures.rest_example.dto.ProductCheckAvailabilityDTO;
import com.com.javarush.lectures.rest_example.entity.Product;
import com.com.javarush.lectures.rest_example.mapper.ProductMapper;
import com.com.javarush.lectures.rest_example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/acc")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @GetMapping("/availability")
    public List<ProductAvailabilityDTO> getProductAvailability(@RequestParam String city) {
        List<Product> products = productRepository.findByCity(city);
        return products.stream()
                .map(productMapper::toAvailabilityDTO)
                .collect(Collectors.toList());
    }

    @PostMapping("/sweater")
    public ResponseEntity<String> addProduct(@RequestBody ProductCheckAvailabilityDTO dto) {
        Product product = productMapper.toProduct(dto);
        productRepository.save(product);
        return ResponseEntity.ok(dto.getPartNumber());
    }
}
