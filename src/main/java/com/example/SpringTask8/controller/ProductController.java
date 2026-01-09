package com.example.SpringTask8.controller;

import com.example.SpringTask8.entity.Product;
import com.example.SpringTask8.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestBody Product product,@RequestParam int user_id){
        String s = productService.addProduct(product,user_id);
        return new ResponseEntity<>(s,HttpStatus.CREATED);
    }

    @PatchMapping("/update")
    public ResponseEntity<?> updateProduct(@RequestBody Product product,@RequestParam Integer id){
        String s = productService.updateProduct(product,id);
        return new ResponseEntity<>(s,HttpStatus.OK);
    }

    @GetMapping("/getProduct")
    public ResponseEntity<?> getProduct(@RequestParam Integer id){
        Product productById = productService.getProductById(id);
        return new ResponseEntity<>(productById,HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllProduct(){
        List<Product> productList = productService.getAllProduct();
        return new ResponseEntity<>(productList,HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteProduct(@RequestParam Integer id){
        String s = productService.deleteProduct(id);
       return new ResponseEntity<>(s,HttpStatus.OK);
    }
}
