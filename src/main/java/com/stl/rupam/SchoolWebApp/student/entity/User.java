package com.stl.rupam.SchoolWebApp.student.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Data
public class User {
//	private Long id;
//	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Id
	@NotEmpty(message = "username is mandetory")
	@Pattern(regexp = "[a-zA-Z0-9]{4,}")
	private String userName;
		
	@NotEmpty(message = "password is mandetory")
	@Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z]).{5,}")
	private String userPassword;
	
	@NotEmpty(message = "userID is mandetory")
	private String userID;
	
	@NotEmpty(message = "name is mandetory")
	@Pattern(regexp = "[a-zA-Z]{2}[a-zA-Z ]+", message = "please add valid name")
	private String name;
	
	@NotNull(message = "please add valid age")
	@Positive(message = "age should be positive")
	@Min(value = 6, message = "age must be atleast 6")
	@Max(value = 18, message = "age must be less than 18")
	private int age;

//	@NotNull(message = "DOB is mandetory")
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
	
	
	public User()
	{
		
	}


	public User(@NotEmpty(message = "username is mandetory") @Pattern(regexp = "[a-zA-Z0-9]{4,}") String userName,
			@NotEmpty(message = "password is mandetory") @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z]).{5,}") String userPassword,
			@NotEmpty(message = "userID is mandetory") String userID,
			@NotEmpty(message = "firstname is mandetory") @Pattern(regexp = "[a-zA-Z]{2}[a-zA-Z ]+", message = "please add valid name") String name,
			@NotNull(message = "please add valid age") @Positive(message = "age should be positive") @Min(value = 6, message = "age must be atleast 6") @Max(value = 18, message = "age must be less than 18") int age,
			@NotNull(message = "DOB is mandetory") LocalDate birthDate,
			@NotEmpty(message = "gender is mandetory") String gender,
			@NotEmpty(message = "address is mandetory") @Pattern(regexp = "^[a-zA-Z0-9 .,-]+$", message = "please add valid address") String address,
			@NotEmpty(message = "phone no is mandetory") @Positive(message = "phoneNo sould be positive") @Pattern(regexp = "(0|91)?[6-9][0-9]{9}", message = "please add valid phone no") String phoneNo,
			@NotEmpty(message = "email is mandetory") @Email(message = "please give valid email") String email,
			@NotEmpty(message = "Class is mandetory") @Pattern(regexp = "[a-zA-Z]{3,}", message = "please add valid class") String classe,
			@NotEmpty(message = "section is mandetory") @Pattern(regexp = "[A-D]", message = "please add valid section") String section) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.userID = userID;
		this.name = name;
		this.age = age;
		this.birthDate = birthDate;
		this.gender = gender;
		this.address = address;
		this.phoneNo = phoneNo;
		this.email = email;
		this.classe = classe;
		this.section = section;
	}
	
	
	public User(
			@NotEmpty(message = "password is mandetory") @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z]).{5,}") String userPassword,
			@NotEmpty(message = "userID is mandetory") String userID,
			@NotEmpty(message = "firstname is mandetory") @Pattern(regexp = "[a-zA-Z]{2}[a-zA-Z ]+", message = "please add valid name") String name,
			@NotNull(message = "please add valid age") @Positive(message = "age should be positive") @Min(value = 6, message = "age must be atleast 6") @Max(value = 18, message = "age must be less than 18") int age,
			@NotNull(message = "DOB is mandetory") LocalDate birthDate,
			@NotEmpty(message = "gender is mandetory") String gender,
			@NotEmpty(message = "address is mandetory") @Pattern(regexp = "^[a-zA-Z0-9 .,-]+$", message = "please add valid address") String address,
			@NotEmpty(message = "phone no is mandetory") @Positive(message = "phoneNo sould be positive") @Pattern(regexp = "(0|91)?[6-9][0-9]{9}", message = "please add valid phone no") String phoneNo,
			@NotEmpty(message = "email is mandetory") @Email(message = "please give valid email") String email,
			@NotEmpty(message = "Class is mandetory") @Pattern(regexp = "[a-zA-Z]{3,}", message = "please add valid class") String classe,
			@NotEmpty(message = "section is mandetory") @Pattern(regexp = "[A-D]", message = "please add valid section") String section) {
		super();
		this.userPassword = userPassword;
		this.userID = userID;
		this.name = name;
		this.age = age;
		this.birthDate = birthDate;
		this.gender = gender;
		this.address = address;
		this.phoneNo = phoneNo;
		this.email = email;
		this.classe = classe;
		this.section = section;
	}
	
	










	
}