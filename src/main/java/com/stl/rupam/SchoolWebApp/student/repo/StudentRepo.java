package com.stl.rupam.SchoolWebApp.student.repo;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.stl.rupam.SchoolWebApp.student.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {
	
	Optional<Student> findByEmail(String email);
	
	@Transactional
	@Modifying
	@Query(value = "insert into user_role(user_id, role_id) values (?,?)", nativeQuery = true)
	void setRole(String userName, String user_role);

}
