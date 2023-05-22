package com.stl.rupam.SchoolWebApp.student;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.stl.rupam.SchoolWebApp.student.entity.Student;
import com.stl.rupam.SchoolWebApp.student.repo.StudentRepo;

//@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@EnableAutoConfiguration(exclude=AutoConfigureTestDatabase.class)
@AutoConfigureTestDatabase(replace= Replace.NONE)
public class StudentRepoTest {
	
	@Autowired
	private StudentRepo studentRepo;
	
	//JUnit test for save teacher
	@Test
	@Order(1)
	@Rollback(value = false)
	public void saveStudentTest()
	{
		Student student = Student.builder()
				.userName("ram123")
				.password("ram@pass")
				.name("Ramesh")
				.email("ram@gmail.com")
				.build();
		
		studentRepo.save(student);
		
		Assertions.assertThat(student.getId()).isGreaterThan(0);
	}
	
	@Test
	@Order(2)
//	@Rollback(value = false)
	public void getStudentTest()
	{
		Student student = studentRepo.findById(3L).get();
		
		Assertions.assertThat(student.getId()).isEqualTo(3L);
	}
	
	@Test
	@Order(3)
//	@Rollback(value = false)
	public void getListOfStudentsTest()
	{
		
		List<Student> students = studentRepo.findAll();
		
		Assertions.assertThat(students.size()).isGreaterThan(0);
	}
	
	@Test
	@Order(4)
	@Rollback(value = false)
	public void updateStudentTest()
	{
		Student student = studentRepo.findById(3L).get();
		
		student.setEmail("ramesh@gmail.com");
		
		Student studentUpdated = studentRepo.save(student);
		
		Assertions.assertThat(studentUpdated.getEmail()).isEqualTo("ramesh@gmail.com");
	}
	
	@Test
	@Order(5)
	@Rollback(value = false)
	public void deleteStudentTest()
	{
		Student student = studentRepo.findById(3L).get();
		
		studentRepo.delete(student);
		
//		studentRepo.deleteById(2L);
		
		Student student2 = null;
		
		Optional<Student> optionalStudent = studentRepo.findByEmail("ramesh@gmail.com");
		
		if(optionalStudent.isPresent())
		{
			student2 = optionalStudent.get();
		}
		
		Assertions.assertThat(student2).isNull();
	}

}

//https://stackoverflow.com/questions/53002232/spring-boot-datajpatest-unit-test-reverting-to-h2-instead-of-mysql
//https://www.springboottutorial.com/junit-tutorial-for-beginners


