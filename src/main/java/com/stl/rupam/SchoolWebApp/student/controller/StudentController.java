package com.stl.rupam.SchoolWebApp.student.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stl.rupam.SchoolWebApp.student.entity.Student;
//import com.stl.rupam.SchoolWebApp.student.repo.StudentRepo;
//import com.stl.rupam.SchoolWebApp.student.service.BookRestConsumer;
import com.stl.rupam.SchoolWebApp.student.service.StudentService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;

//	@Autowired
//	private StudentRepo studentRepo;

//	@Autowired
//	private LeaveRepo leaveRepo;

	@GetMapping("/app")
	public String stu_controller() {
		return "This is student controller";
	}

	@GetMapping("/listStudents")
	public List<Student> listAllStudents() {
		return studentService.listAllStudents();
	}

	@PostMapping("/addStudent")
	public ResponseEntity<Student> saveStudent(@Valid @RequestBody Student student) {
		return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentByID(@PathVariable("id") Long id) {
		return new ResponseEntity<Student>(studentService.getStudentByID(id), HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<Student> updateStudent(@Valid @PathVariable("id") Long id, @RequestBody Student student) {
		return new ResponseEntity<Student>(studentService.updateStudent(student, id), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id) {
		studentService.deleteStudent(id);
		return new ResponseEntity<String>("Student deleted successfully", HttpStatus.OK);
	}

	@GetMapping("/countStudent")
	public ResponseEntity<Long> countStudent() {
		Long n1 = studentService.countStudent();
		return new ResponseEntity<Long>(n1, HttpStatus.OK);
	}

//      @Autowired
//      private BookRestConsumer consumer;
//
//      @GetMapping("/data")
//      public String getStudentInfo() {
//         System.out.println(consumer.getClass().getName());  //prints as a proxy class
//         return "Accessing from STUDENT-SERVICE ==> " +consumer.getBookData();
//      }
//
//      @GetMapping("/allBooks")
//      public String getBooksInfo() {
//         return "Accessing from STUDENT-SERVICE ==> " + consumer.getAllBooks();
//      }
//
//      @GetMapping("/getOneBook/{id}")
//      public String getOneBookForStd(@PathVariable Integer id) {
//         return "Accessing from STUDENT-SERVICE ==> " + consumer.getBookById(id); 
//      }
//
//      @GetMapping("/entityData")
//      public String printEntityData() {
//         ResponseEntity<String> resp = consumer.getEntityData();
//         return "Accessing from STUDENT-SERVICE ==> " + resp.getBody() +" , status is:" + resp.getStatusCode();
//      }
}