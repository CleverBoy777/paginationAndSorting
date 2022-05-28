package com.example.paginationandsortingwithspringdatajpa.service;

import com.example.paginationandsortingwithspringdatajpa.entity.Product;
import com.example.paginationandsortingwithspringdatajpa.payload.ApiResponse;
import com.example.paginationandsortingwithspringdatajpa.payload.ProductDto;
import com.example.paginationandsortingwithspringdatajpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public ApiResponse addProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setQuantity(productDto.getQuantity());
        product.setPrice(productDto.getPrice());
        productRepository.save(product);
        return new ApiResponse("Product Saqlandi!",true);
    }

    public List<Product> getProduct() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    public List<Product> productWithSorting(String field) {
        List<Product> products = productRepository.findAll(Sort.by(Sort.Direction.DESC, field));
        return products;
    }


    public Page<Product> productWIthPagination(int offset,int pageSize){
        Page<Product> products = productRepository.findAll(PageRequest.of(offset, pageSize));
        return products;
    }
}
