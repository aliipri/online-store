package com.com.javarush.lectures.rest_example.mapper;

import com.com.javarush.lectures.rest_example.dto.ProductAvailabilityDTO;
import com.com.javarush.lectures.rest_example.dto.ProductCheckAvailabilityDTO;
import com.com.javarush.lectures.rest_example.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "partNumberId", source = "partNumberId")
    @Mapping(target = "storeAddress", source = "address")
    ProductAvailabilityDTO toAvailabilityDTO(Product product);

    @Mapping(target = "address", source = "address")
    @Mapping(target = "partNumberId", expression = "java(Long.parseLong(dto.getPartNumber()))")
    @Mapping(target = "cost", source = "cost")
    Product toProduct(ProductCheckAvailabilityDTO dto);
}
