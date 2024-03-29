package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	 List<User> findByGender(String gender);

	    List<User> findByActivityLevelGreaterThanEqual(int level);

}
