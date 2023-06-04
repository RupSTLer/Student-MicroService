package com.stl.rupam.SchoolWebApp.student.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stl.rupam.SchoolWebApp.student.entity.User;


public interface UserRepo extends JpaRepository<User, String> {
	
	Optional<User> getStudentByUserID(String userID);

}
