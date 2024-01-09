package com.example.CURD2.Crud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CURD2.Crud.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

}

