package com.example.SpringTask8.serviceImpl;

import com.example.SpringTask8.entity.Category;
import com.example.SpringTask8.entity.Dealer;
import com.example.SpringTask8.entity.Product;
import com.example.SpringTask8.repository.CategoryRepo;
import com.example.SpringTask8.repository.ProductRepo;
import com.example.SpringTask8.repository.UserRepo;
import com.example.SpringTask8.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    UserRepo userRepo;

    @Override
    public String addProduct(Product product,int user_id) {
        try{
            Dealer dealer = userRepo.findById(user_id).get();
            product.setDealer(dealer);
            dealer.getProducts().add(product);
            userRepo.save(dealer);
            return "Product added successfully";
        }catch(RuntimeException e){

            return e.getMessage();
        }
    }

    @Override
    public String updateProduct(Product product,int id) {
        try{
            Product product1 = productRepo.findById(id).get();
            product1.setName(product.getName());
            product1.setPrice(product.getPrice());
            product1.setStock(product.getStock());
            product1.setDescription(product.getDescription());
            product1.setCategories(product.getCategories());
            productRepo.save(product1);
            List<Category> categories = product.getCategories();
            for (Category category : categories) {
                categoryRepo.save(category);
            }


            return "Product updated successfully";
        } catch (RuntimeException e) {
            return e.getMessage();
        }

    }

    @Override
    public String deleteProduct(Integer id) {
        try{
            Product product = productRepo.findById(id).get();
            if(product != null){
                productRepo.delete(product);
                return  "Product deleted successfully";
            }else{
                return "Product not found";
            }


        }catch(RuntimeException e){
            return e.getMessage();
        }

    }

    @Override
    public Product getProductById(Integer id) {
        try{
            return productRepo.findById(id).get();

        }  catch(RuntimeException e){
            return null;
        }
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepo.findAll();
    }

    private void saveCategory(List<Category> categories){

        for (Category category : categories) {
            boolean b = categoryRepo.existsByName(category.getName());
            if(!b){
                categoryRepo.save(category);
            }
        }
    }
}

