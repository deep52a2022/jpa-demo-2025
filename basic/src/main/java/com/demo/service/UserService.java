package com.demo.service;


import com.demo.entity.Address;
import com.demo.entity.Order;
import com.demo.entity.User;
import com.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addTestUser(){
        User user = new User();
        user.setName("John Doe");

        // Create Address
        Address address = new Address();
        address.setStreet("123 Main St");
        address.setCity("New York");
        address.setZipCode("10001");


        user.setAddress(address);
        // Set the bidirectional relationship
        address.setUser(user);

        // Create orders
        Order order1 = new Order();
        order1.setProductName("Laptop");
        order1.setUser(user);

        Order order2 = new Order();
        order2.setProductName("Phone");
        order2.setUser(user);

        // Set orders to the user
        user.setOrders(Arrays.asList(order1, order2));

        // Save the user (cascade will save the orders)
        userRepository.save(user);
        log.info("Test User saved.");
    }


    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUserById(Integer id){
        if(userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
            log.info("User having ID: {} was deleted.", id);
        }
        else{
            log.info("No User Found with ID: {}. Cannot delete.", id);
        }
    }
}
