package com.stl.rupam.SchoolWebApp.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.stl.rupam.SchoolWebApp.student.entity.Student;
import com.stl.rupam.SchoolWebApp.student.entity.User;
import com.stl.rupam.SchoolWebApp.student.exception.ResourceNotFoundException;
import com.stl.rupam.SchoolWebApp.student.repo.StudentRepo;
import com.stl.rupam.SchoolWebApp.student.repo.UserRepo;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private UserRepo userRepo;

	public Student saveStudent(Student student) {
		Long c = studentRepo.count();
		String u = "SMS00" + (c+1);
		student.setStudentId(u);

		// checking duplicate entries via email
		try {
			studentRepo.findByEmail(student.getEmail()).get();
			studentRepo.findByPhoneNo(student.getPhoneNo()).get();
		} catch (Exception ex) {
//			ex.printStackTrace();
			
			Student s = studentRepo.save(student);
			userRepo.save(new User(s.getUserName(), s.getPassword(), s.getStudentId(), s.getName(), s.getAge(), s.getBirthDate(), s.getGender(), s.getAddress(), s.getPhoneNo(), s.getEmail(), s.getClasse(), s.getSection()));
			
			studentRepo.setRole(s.getUserName(), "Student");
			
			return s;
		}
		return null;
	}
	
	public String validateStudent()
	{
		
		return null;
	}

	public List<Student> listAllStudents() {
		return studentRepo.findAll();
	}

//	public Student getStudentByID(Long id) {
//		return studentRepo.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("Student not exist with id: " + id));
//	}
	
	public Student getStudentByStudentId(String studentId) {
		return studentRepo.getStudentByStudentId(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student not exist with studentId: " + studentId));
	}

	public Student updateStudent(String studentId, Student student) {

		Student existingStudent = studentRepo.getStudentByStudentId(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student not exist with studentId: " + studentId));

		return studentRepo.saveAndFlush(student);
//		s.getUserName(), 
		
//		Student s = studentRepo.saveAndFlush(student);
//		userRepo.saveAndFlush(new User(s.getPassword(), s.getStudentId(), s.getName(), s.getAge(), s.getBirthDate(), s.getGender(), s.getAddress(), s.getPhoneNo(), s.getEmail(), s.getClasse(), s.getSection()));
//		
//		studentRepo.setRole(s.getUserName(), "Student");
//		
//		return s;
		
	}

	public void deleteStudent(String studentId) {
		studentRepo.getStudentByStudentId(studentId)
		.orElseThrow(() -> new ResourceNotFoundException("Student not exist with studentId: " + studentId));
		studentRepo.deleteById(studentId);
//		deleteStudentUser(studentId);
	}

	public Long countStudent() {
		return studentRepo.count();
	}
	
//	public void deleteStudentUser(String userID) {
//		User existingStudentUser = userRepo.getStudentByUserID(userID)
//		.orElseThrow(() -> new ResourceNotFoundException("Student not exist with userID: " + userID));
//		studentRepo.deleteRole(existingStudentUser.getUserName());
//		userRepo.deleteById(userID);
//	}

}
