package com.stl.rupam.SchoolWebApp.student.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stl.rupam.SchoolWebApp.student.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {
	
	Optional<Student> findByEmail(String email);

}
