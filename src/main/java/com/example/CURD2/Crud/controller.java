package com.example.CURD2.Crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CURD2.Crud.entity.Order;
import com.example.CURD2.Crud.entity.User;

@RestController
@RequestMapping("/api")
public class controller {
    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;


    @GetMapping("/users")
    public List<User> findUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }
    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable Long id,@RequestBody User user){
        System.out.println(id);
        return userService.updatedUser(id, user);
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }

    @GetMapping("/orders")
    public List<Order>getOrders(){
        return orderService.getAllOrders();
    }
   @PostMapping("/order")
    public Order createOrder (@RequestBody Order order){
        return orderService.createOrder(order);
    }

   @PutMapping("/order/{id}")
  public Order updateOrder(@PathVariable Long id,@RequestBody Order order){
        System.out.println(id);
        return orderService.updateOrder(id, order);
    }
    
    @DeleteMapping("/order/{id}")
    public String deleteOrder(@PathVariable Long id){
        return orderService.deleteOrder(id);
    }




}