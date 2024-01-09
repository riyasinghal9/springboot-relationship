package com.example.CURD2.Crud;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.CURD2.Crud.entity.Order;
import com.example.CURD2.Crud.entity.User;

@Service
public class OrderService {

    @Autowired
    private OrderRespository orderRespository;

    public List<Order> getAllOrders(){
        return orderRespository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRespository.findById(id);
    }

    public Order createOrder(Order order){
        return orderRespository.save(order);
    }

    public Order updateOrder(Long id , Order order){
    Optional<Order> optionalOrder = orderRespository.findById(id);

        if (!optionalOrder.isPresent()) {
            System.out.println("User not found");
            return null;
        }
        Order data = optionalOrder.get();

        data.setOrderDescription(order.getOrderDescription());
        return orderRespository.save(data);

    }

    public String deleteOrder(Long id) {
        Optional<Order> optionalOrder = orderRespository.findById(id);

        if (!optionalOrder.isPresent()) {
            System.out.println("User not found");
            return null;
        }
    
        orderRespository.deleteById(id);
        return "User Delete";

    }
}
