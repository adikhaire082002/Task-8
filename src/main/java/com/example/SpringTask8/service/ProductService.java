package com.example.SpringTask8.service;

import com.example.SpringTask8.entity.Product;

import java.util.List;

public interface ProductService {

    public  String addProduct(Product product,int user_id);

    public  String updateProduct(Product product,int id);

    public  String deleteProduct(Integer id);

    public  Product getProductById(Integer id);
    public List<Product> getAllProduct();
}
