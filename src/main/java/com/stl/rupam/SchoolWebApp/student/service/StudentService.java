package com.stl.rupam.SchoolWebApp.student.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.stl.rupam.SchoolWebApp.student.entity.Student;
import com.stl.rupam.SchoolWebApp.student.exception.ResourceNotFoundException;
import com.stl.rupam.SchoolWebApp.student.repo.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo studentRepo;

//	@Autowired
//	private PasswordEncoder passwordEncoder;

	public Student saveStudent(Student student) {
		Long c = studentRepo.count();
		String u = "SMS00" + c;
		student.setStudentId(u);

		// checking duplicate entries via email
		try {
			studentRepo.findByEmail(student.getEmail()).get();
		} catch (Exception ex) {
//			ex.printStackTrace();
			Student s = studentRepo.save(student);
			studentRepo.setRole(s.getUserName(), "Student");
			return s;
		}

		return null;

	}

	public List<Student> listAllStudents() {
		return studentRepo.findAll();
	}

	public Student getStudentByID(Long id) {
		return studentRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not exist with id: " + id));
	}

	public Student updateStudent(Student student, Long id) {
		Student existingStudent = studentRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not exist with id: " + id));

//		existingStudent.setStudentID(student.getStudentID());
//		existingStudent.setId(student.getId());
//		existingStudent.setUserName(student.getUserName());
//		existingStudent.setName(student.getName());
//		existingStudent.setEmail(student.getEmail());
//		existingStudent.setPassword(getEncodedPassword(student.getPassword()));

//		studentRepo.save(existingStudent);
		return studentRepo.saveAndFlush(student);
//		return existingStudent;
	}

	public void deleteStudent(Long id) {
		studentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not exist with id: " + id));
		studentRepo.deleteById(id);
	}

	public Long countStudent() {
		return studentRepo.count();
	}

//	public String getEncodedPassword(String password) {
//		return passwordEncoder.encode(password);
//	}



}
