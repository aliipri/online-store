package com.com.javarush.lectures.rest_example.mapper;

import com.com.javarush.lectures.rest_example.dto.ProductAvailabilityDTO;
import com.com.javarush.lectures.rest_example.dto.ProductCheckAvailabilityDTO;
import com.com.javarush.lectures.rest_example.entity.Product;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-02T02:22:49+0300",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductAvailabilityDTO toAvailabilityDTO(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductAvailabilityDTO productAvailabilityDTO = new ProductAvailabilityDTO();

        productAvailabilityDTO.setPartNumberId( product.getPartNumberId() );
        productAvailabilityDTO.setStoreAddress( product.getAddress() );
        productAvailabilityDTO.setCity( product.getCity() );
        productAvailabilityDTO.setSize( product.getSize() );
        productAvailabilityDTO.setColor( product.getColor() );
        productAvailabilityDTO.setCount( product.getCount() );

        return productAvailabilityDTO;
    }

    @Override
    public Product toProduct(ProductCheckAvailabilityDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Product product = new Product();

        product.setAddress( dto.getAddress() );
        product.setCost( dto.getCost() );
        product.setCity( dto.getCity() );
        product.setSize( dto.getSize() );
        product.setColor( dto.getColor() );
        product.setCount( dto.getCount() );

        product.setPartNumberId( Long.parseLong(dto.getPartNumber()) );

        return product;
    }
}
