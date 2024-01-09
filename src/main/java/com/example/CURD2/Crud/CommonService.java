package com.example.CURD2.Crud;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CURD2.Crud.entity.MapDTO;
import com.example.CURD2.Crud.entity.Order;
import com.example.CURD2.Crud.entity.User;

@Service
public class CommonService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRespository orderRespository;

    public String mapToUser(MapDTO mapDTO) {
        Optional<User> optionalUser = userRepository.findById(mapDTO.getUserId());

        if (!optionalUser.isPresent()) {
            System.out.println("User not found");
            return null;
        }

        Optional<Order> optionalOrder = orderRespository.findById(mapDTO.getOrderId());

        if (!optionalOrder.isPresent()) {
            System.out.println("User not found");
            return null;
        }

        Order order = optionalOrder.get();
        User user = optionalUser.get();
        
        order.setUser(user);
        return "Hi";
        
    }
}


