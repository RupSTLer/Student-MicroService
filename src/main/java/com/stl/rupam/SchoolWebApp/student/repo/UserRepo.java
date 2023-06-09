package com.stl.rupam.SchoolWebApp.student.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.stl.rupam.SchoolWebApp.student.entity.User;


public interface UserRepo extends JpaRepository<User, String> {
	
	Optional<User> getStudentByUserID(String userID);
	
	@Transactional
	@Modifying
	@Query(value = "delete from user where userid = ?", nativeQuery = true)
	void deleteUser(String userID);

}
