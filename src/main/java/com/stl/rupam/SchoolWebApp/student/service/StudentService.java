package com.stl.rupam.SchoolWebApp.student.service;

import java.time.LocalDate;
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

	public String saveStudent(Student student) {
		Long c = studentRepo.count();
		String u = "SMS00" + (c + 1);
		student.setStudentId(u);

		String stu = validateStudent(student);

		if (stu == null) {
			Student s = studentRepo.save(student);
			
			userRepo.save(new User(s.getUserName(), s.getPassword(), s.getStudentId(), s.getName(), s.getAge(),
					s.getBirthDate(), s.getGender(), s.getAddress(), s.getPhoneNo(), s.getEmail(), s.getClasse(),
					s.getSection()));
			
			studentRepo.setRole(s.getUserName(), "Student");

			return "Student added successfully";
		} else {
			return stu;
		}

	}

	public String updateStudent(String studentId, Student student) {

		Student existingStudent = studentRepo.getStudentByStudentId(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student not exist with studentId: " + studentId));

		String stu = validateUpdateStudent(student);

		if (stu == null) {
			Student s = studentRepo.save(student);
			
			userRepo.save(new User(s.getUserName(), s.getPassword(), s.getStudentId(), s.getName(), s.getAge(),
					s.getBirthDate(), s.getGender(), s.getAddress(), s.getPhoneNo(), s.getEmail(), s.getClasse(),
					s.getSection()));

			return "Student details updated successfully";
		} else {
			return stu;
		}

	}

	public String validateStudent(Student student) {

		LocalDate minDate = LocalDate.of(2010, 1, 1);
		LocalDate maxDate = LocalDate.of(2020, 12, 31);
		LocalDate birthDate = student.getBirthDate();

		try {

			if (birthDate.isBefore(minDate) || birthDate.isAfter(maxDate)) {
				throw new IllegalArgumentException("Invalid Bithdate. Birthdate must be in between 2010 to 2020");
			}
			if(student.getAge() < 5 && student.getAge() > 15)
			{
				throw new IllegalArgumentException("Age must be in between 5 to 15");
			}

			List<Student> existingEmail = studentRepo.findByEmail(student.getEmail());

			if (!existingEmail.isEmpty()) {
				throw new IllegalArgumentException(student.getEmail()+ " :Email already exists");
			}

			List<Student> existingUserName = studentRepo.findByUserName(student.getUserName());

			if (!existingUserName.isEmpty()) {
				throw new IllegalArgumentException(student.getUserName()+ " :Username already exists");
			}

			List<Student> existingPhoneNo = studentRepo.findByPhoneNo(student.getPhoneNo());

			if (!existingPhoneNo.isEmpty()) {
				throw new IllegalArgumentException(student.getPhoneNo()+ " :PhoneNo already exists");
			}

		} catch (Exception ex) {
			return ex.getMessage();
		}

		return null;
	}
	
	public String validateUpdateStudent(Student student) {

		LocalDate minDate = LocalDate.of(2010, 1, 1);
		LocalDate maxDate = LocalDate.of(2020, 12, 31);
		LocalDate birthDate = student.getBirthDate();

		try {

			if (birthDate.isBefore(minDate) || birthDate.isAfter(maxDate)) {
				throw new IllegalArgumentException("Invalid Bithdate. Bithdate must be in between 2010 to 2020");
			}

		} catch (Exception ex) {
			return ex.getMessage();
		}

		return null;
	}
	
	

	public Student getStudentByStudentId(String studentId) {
		return studentRepo.getStudentByStudentId(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student not exist with studentId: " + studentId));
	}

	public List<Student> listAllStudents() {
		return studentRepo.findAll();
	}

	public void deleteStudent(String studentId) {
		studentRepo.getStudentByStudentId(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student not exist with studentId: " + studentId));
		studentRepo.deleteById(studentId);
		deleteStudentUser(studentId);
	}

	public Long countStudent() {
		return studentRepo.count();
	}

	public void deleteStudentUser(String userID) {
		User existingStudentUser = userRepo.getStudentByUserID(userID)
				.orElseThrow(() -> new ResourceNotFoundException("Student not exist with userID: " + userID));
		studentRepo.deleteRole(existingStudentUser.getUserName());
		userRepo.deleteUser(userID);
	}

}
