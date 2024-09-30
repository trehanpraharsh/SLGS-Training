package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.entity.Owner;


@Repository
public interface OwnerRepo extends JpaRepository<Owner, Integer> {
	

}
