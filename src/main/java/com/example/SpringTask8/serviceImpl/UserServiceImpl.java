package com.example.SpringTask8.serviceImpl;

import com.example.SpringTask8.entity.Dealer;
import com.example.SpringTask8.entity.Product;
import com.example.SpringTask8.entity.Profile;
import com.example.SpringTask8.repository.UserRepo;
import com.example.SpringTask8.service.ProductService;
import com.example.SpringTask8.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    ProductService productService;

    @Override
    public String addUser(Dealer dealer) {

        try{
            if(userRepo.existsByEmail(dealer.getEmail())){
                return "dealer already exists";
            }
            dealer.getProfile();
            userRepo.save(dealer);
            return "dealer added";
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public String updateUser(Dealer dealer, int id) {
        try{
            if(userRepo.existsById(id)){
                Dealer dealer1 = userRepo.findById(id).get();
                if(userRepo.existsByEmail(dealer.getEmail())){
                    return "dealer email already exists";
                }
                dealer1.setEmail(dealer.getEmail());
                dealer1.setPassword(dealer.getPassword());
                userRepo.save(dealer1);
                return "dealer updated";
            }else{
                return "dealer not found with given id";
            }
        }catch (RuntimeException e){
            throw new RuntimeException("Something went wrong");
        }
    }

    @Override
    public String deleteUser(Integer id) {
        try{
            if(userRepo.existsById(id)){
                Dealer dealer = userRepo.findById(id).get();
                List<Product> products = dealer.getProducts();
                for(Product product:products){
                    productService.deleteProduct(product.getId());
                }
                userRepo.delete(dealer);
                return "dealer deleted";
            }
            return "user not found with given id";
        }catch (RuntimeException e){
            throw new RuntimeException("Something went wrong");
        }
    }

    @Override
    public Dealer getUserById(Integer id) {
        try{
            if(userRepo.existsById(id)){
                Dealer dealer = userRepo.findById(id).get();
                return dealer;
            }else {
                return null;
            }
        }catch (RuntimeException e){
            throw new RuntimeException("Something went wrong");
        }
    }

    @Override
    public List<Dealer> getAllUser() {
        List<Dealer> all = userRepo.findAll();
        return all;
    }
}
