package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.CartEntity;

public interface CartRepo extends JpaRepository<CartEntity, Long> {

}
