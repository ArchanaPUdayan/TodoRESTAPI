package com.example.SimpleRestApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SimpleRestApplication.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Integer>{

}
