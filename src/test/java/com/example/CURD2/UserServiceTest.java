package com.example.CURD2;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.example.CURD2.Crud.OrderRespository;
import com.example.CURD2.Crud.UserRepository;
import com.example.CURD2.Crud.UserService;

public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    private OrderRespository orderRespository;

    private UserService userService;

     @BeforeEach
    void setUp() {
        this.userService = new UserService(userRepository);
    }

    @Test
    void getAllUsers() {
        userService.getAllUsers();
        verify(userRepository).findAll();
    }

}
