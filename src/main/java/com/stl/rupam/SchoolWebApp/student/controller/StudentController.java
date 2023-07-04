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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/student")
@Api(tags = "Student Service APIs", value = "Student Controller", description = "it will handle the web requests of student service")
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	@ApiOperation(value = "test student service")
	@GetMapping("/studentApp")
	public String student_controller() {
		return "This is student service application";
	}
	
	@ApiOperation(value = "Add a new Student into School Management System", notes = "returns a string when successfully added")
	@PostMapping("/addStudent")
	public ResponseEntity<String> saveStudent(@Valid @RequestBody Student student) {
		
		return new ResponseEntity<String>(studentService.saveStudent(student), HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Update an existing student details", notes = "returns a string when successfully updated")
	@PutMapping("{studentId}")
	public ResponseEntity<String> updateStudent(@Valid @PathVariable String studentId, @RequestBody Student student) {
		
		return new ResponseEntity<String>(studentService.updateStudent(studentId, student), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Fetch Student details by studentId", notes = "returns the fetched student object")
	@GetMapping("/{studentId}")
	public ResponseEntity<Student> getStudentByStudentId(@PathVariable String studentId) {
		return new ResponseEntity<Student>(studentService.getStudentByStudentId(studentId), HttpStatus.OK);
	}

	@ApiOperation(value = "List all the students present in the system", notes = "returns a list of students")
	@GetMapping("/listStudents")
	public List<Student> listAllStudents() {
		return studentService.listAllStudents();
	}

	@ApiOperation(value = "Delete a student by studentId", notes = "returns a string when successfully deleted")
	@DeleteMapping("{studentId}")
	public ResponseEntity<String> deleteStudent(@PathVariable String studentId) {
		studentService.deleteStudent(studentId);
		return new ResponseEntity<String>("Student deleted successfully", HttpStatus.OK);
	}

	@ApiOperation(value = "Count no of students present in system", notes = "returns the fetched count of students")
	@GetMapping("/countStudent")
	public ResponseEntity<Long> countStudent() {
		Long n1 = studentService.countStudent();
		return new ResponseEntity<Long>(n1, HttpStatus.OK);
	}


}


