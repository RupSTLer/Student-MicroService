package com.stl.rupam.SchoolWebApp.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.junit.jupiter.api.MethodOrderer;

import com.stl.rupam.SchoolWebApp.student.entity.Student;
import com.stl.rupam.SchoolWebApp.student.entity.User;
import com.stl.rupam.SchoolWebApp.student.repo.StudentRepo;
import com.stl.rupam.SchoolWebApp.student.repo.UserRepo;
import com.stl.rupam.SchoolWebApp.student.service.StudentService;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = { StudentServiceTest.class })
public class StudentServiceTest {

	@Mock
	StudentRepo studentRepo;

	@Mock
	UserRepo userRepo;

	@InjectMocks
	StudentService studentService;

	// JUnit test for save Student
	@Test
	@Order(1)
	@Rollback(value = false)
	public void saveStudentTest() {
		Student mockStudent = new Student("SMS001", "ram123", "Ram@pass", "Ramesh", LocalDate.of(2010, 3, 24), "rami@gmail.com");

		when(studentRepo.save(mockStudent)).thenReturn(mockStudent);    //mocking
		assertEquals("Student added successfully", studentService.saveStudent(mockStudent));
		verify(studentRepo, times(1)).save(mockStudent);
	}

	// JUnit test for getStudentByStudentID
	@Test
	@Order(2)
	@Rollback(value = false)
	public void getStudentByStudentIDTest() {

		String studentId = "SMS002";
		Student student = new Student(studentId, "ram123", "Ram@pass", "Ramesh", "rami@gmail.com");
		
		when(studentRepo.getStudentByStudentId(studentId)).thenReturn(Optional.of(student));
		
		Student mockService = studentService.getStudentByStudentId(studentId);

		assertEquals(student, mockService);
		verify(studentRepo, times(1)).getStudentByStudentId(studentId);
	}

	// JUnit test for getListOfStudents
	@Test
	@Order(3)
	@Rollback(value = false)
	public void getListOfStudentsTest() {
		List<Student> studentList = new ArrayList<Student>();

		studentList.add(new Student("SMS001", "ram123", "Ram@pass", "Ramesh", "rami@gmail.com"));
		studentList.add(new Student("SMS002", "sam123", "Sam@pass", "Sama", "sam@gmail.com"));

		when(studentRepo.findAll()).thenReturn(studentList);   //mocking

		List<Student> mockService = studentService.listAllStudents();

		assertEquals(studentList, mockService);
		verify(studentRepo, times(1)).findAll();

	}

	// JUnit test for update student details
//	@Test
//	@Order(4)
//	@Rollback(value = false)
//	public void updateStudentTest() {
//
//		String studentId = "SMS001";
//		Student existingStudent = new Student(studentId, "ram123", "Ram@pass", "Ramesh", LocalDate.of(2010, 3, 24), "ram@gmail.com");
//		Student updatedStudent = new Student(studentId, "ram123", "Ram@pass", "Ramesh", LocalDate.of(2010, 3, 24), "ramesh@gmail.com");
//
//		when(studentRepo.getStudentByStudentId(studentId)).thenReturn(Optional.of(existingStudent));
//		when(studentRepo.save(existingStudent)).thenReturn(updatedStudent);
//
//		String mockService = studentService.updateStudent(studentId, existingStudent);
//
//		assertEquals("Student details updated successfully", mockService);
//		verify(studentRepo, times(1)).getStudentByStudentId(studentId);
//		verify(studentRepo, times(1)).save(existingStudent);
//
//	}

	// JUnit test for count student
	@Test
	@Order(5)
	@Rollback(value = false)
	public void countStudentTest() {

		Long count = 5L;

		when(studentRepo.count()).thenReturn(count);

		Long mockService = studentService.countStudent();

		assertEquals(count, mockService);
		verify(studentRepo, times(1)).count();

	}

	// JUnit test for delete student
	@Test
	@Order(6)
	@Rollback(value = false)
	public void deleteStudentTest() {
		String studentId = "SMS002";

		Student student = new Student(studentId, "ram123", "Ram@pass", "Ramesh", LocalDate.of(2010, 3, 24), "ram@gmail.com");
		User user = new User("ram123", "Ram@pass", studentId,  "Ramesh", LocalDate.of(2010, 3, 24), "ram@gmail.com");

		when(studentRepo.getStudentByStudentId(studentId)).thenReturn(Optional.of(student)); // mocking
		when(userRepo.getStudentByUserID(studentId)).thenReturn(Optional.of(user)); // mocking

		studentService.deleteStudent(studentId);

		verify(studentRepo, times(1)).getStudentByStudentId(studentId);
		verify(studentRepo, times(1)).deleteById(studentId);
		verify(userRepo, times(1)).getStudentByUserID(studentId);		
		verify(studentRepo, times(1)).deleteRole(student.getUserName());
		verify(userRepo, times(1)).deleteUser(studentId);


	}

}

//https://stackoverflow.com/questions/53002232/spring-boot-datajpatest-unit-test-reverting-to-h2-instead-of-mysql
//https://www.springboottutorial.com/junit-tutorial-for-beginners
