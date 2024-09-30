package com.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.entity.User;

import jakarta.transaction.Transactional;

@Repository
public interface UserRepo extends CrudRepository<User, String> {
	
	@Query("update User set email=?2 where uname=?1")
	@Modifying
	@Transactional
	public int updateUser(String uname, String email);
	

}
