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

	@GetMapping("/studentApp")
	public String student_controller() {
		return "This is student service application";
	}
	
	@PostMapping("/addStudent")
	public ResponseEntity<String> saveStudent(@Valid @RequestBody Student student) {
		
		return new ResponseEntity<String>(studentService.saveStudent(student), HttpStatus.CREATED);
	}
	
	@PutMapping("{studentId}")
	public ResponseEntity<String> updateStudent(@Valid @PathVariable String studentId, @RequestBody Student student) {
		
		return new ResponseEntity<String>(studentService.updateStudent(studentId, student), HttpStatus.OK);
	}
	
	@GetMapping("/{studentId}")
	public ResponseEntity<Student> getStudentByStudentId(@PathVariable String studentId) {
		return new ResponseEntity<Student>(studentService.getStudentByStudentId(studentId), HttpStatus.OK);
	}

	@GetMapping("/listStudents")
	public List<Student> listAllStudents() {
		return studentService.listAllStudents();
	}

	@DeleteMapping("{studentId}")
	public ResponseEntity<String> deleteStudent(@PathVariable String studentId) {
		studentService.deleteStudent(studentId);
		return new ResponseEntity<String>("Student deleted successfully", HttpStatus.OK);
	}

	@GetMapping("/countStudent")
	public ResponseEntity<Long> countStudent() {
		Long n1 = studentService.countStudent();
		return new ResponseEntity<Long>(n1, HttpStatus.OK);
	}


}


