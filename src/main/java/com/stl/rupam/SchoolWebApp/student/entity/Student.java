package com.stl.rupam.SchoolWebApp.student.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "students")
public class Student {

	@Id
	private String studentId;

	@NotEmpty(message = "username is mandetory")
	@Pattern(regexp = "[a-zA-Z0-9]{4,}")
	private String userName;

	@NotEmpty(message = "password is mandetory")
	@Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z]).{5,}")
	private String password;

	@NotEmpty(message = "student name is mandetory")
	@Pattern(regexp = "[a-zA-Z]{2}[a-zA-Z ]+", message = "please add valid name")
	private String name;

	@NotNull(message = "please add valid age")
	@Positive(message = "age should be positive")
	@Min(value = 6, message = "age must be atleast 6")
	@Max(value = 18, message = "age must be less than 18")
	private int age;

//	@Past
	@NotNull(message = "DOB is mandetory")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthDate;

	@NotEmpty(message = "gender is mandetory")
	private String gender;

	@NotEmpty(message = "address is mandetory")
	@Pattern(regexp = "^[a-zA-Z0-9 .,-]+$", message = "please add valid address")
	private String address;

	@NotEmpty(message = "phone no is mandetory")
	@Positive(message = "phoneNo sould be positive")
	@Pattern(regexp = "(0|91)?[6-9][0-9]{9}", message = "please add valid phone no")
	private String phoneNo;

	@NotEmpty(message = "email is mandetory")
	@Email(message = "please give valid email")
	private String email;

	@NotEmpty(message = "Class is mandetory")
	@Pattern(regexp = "[a-zA-Z]{3,}", message = "please add valid class")
	private String classe;

	@NotEmpty(message = "section is mandetory")
	@Pattern(regexp = "[A-D]", message = "please add valid section")
	private String section;
	
	
	
	

	public Student(
			String studentId,
			String userName,
			@NotEmpty(message = "password is mandetory") @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z]).{5,}") String password,
			@NotEmpty(message = "student name is mandetory") @Pattern(regexp = "[a-zA-Z]{2}[a-zA-Z ]+", message = "please add valid name") String name,
			@NotEmpty(message = "email is mandetory") @Email(message = "please give valid email") String email) {
		super();
		this.studentId = studentId;
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.email = email;
	}





	public Student(String studentId,
			@NotEmpty(message = "username is mandetory") @Pattern(regexp = "[a-zA-Z0-9]{4,}") String userName,
			@NotEmpty(message = "password is mandetory") @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z]).{5,}") String password,
			@NotEmpty(message = "student name is mandetory") @Pattern(regexp = "[a-zA-Z]{2}[a-zA-Z ]+", message = "please add valid name") String name,
			LocalDate birthDate,
			@NotEmpty(message = "email is mandetory") @Email(message = "please give valid email") String email) {
		super();
		this.studentId = studentId;
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.birthDate = birthDate;
		this.email = email;
	}

}

///^([+]\d{2})?\d{10}$/                ^[\+]?[(]?[0-9]{3}[)]?[-\s\.]?[5-9]{3}[-\s\.]?[0-9]{4,6}$
