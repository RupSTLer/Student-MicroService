package com.stl.rupam.SchoolWebApp.student.entity;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "students")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@NotEmpty(message = "student id is mandetory")
//	@Pattern(regexp = "^[SMS]{3}[0-9]{3}$", message = "please add valid ID")
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
	
	@Email(message = "email not valid")
//	@Pattern(regexp = "^([a-zA-Z0-9_\\\\-\\\\.]+)@([a-zA-Z0-9_\\\\-\\\\.]+)\\\\.([a-zA-Z]{2,5})$")
	private String email;
	
	
//	@Column(name = "full_name")
//	private String fullName;
//	
//	private String firstName;
//	
//	private String lastName;
//	
////	@Column(name = "gender")
//	private String gender;
//	
////	@Column(name = "email", nullable = false)
//	private String email;
//	
////	@Column(name = "phone_no")
//	private String phoneNo;
//	
////	@Column(name = "DOB", nullable = false)
//	private String DOB;
//	
////	@Column(name = "full_name")
//	private String address;
//	
////	@Column(name = "class")
//	private String classe;
//	
////	@Column(name = "full_name")
//	private String section;

	
	
	
	
	
	
	
//	@ElementCollection(fetch = FetchType.EAGER, targetClass = Role.class)
//	@Enumerated(EnumType.STRING)
//	@Transient
//	private Set<Role> role;
	
	
	//@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinTable(name = "USER_ROLE", 
//				joinColumns = { 
//						@JoinColumn(name = "ROLE_ID") 
//						}, 
//				inverseJoinColumns = {
//						@JoinColumn(name = "STUDENT_ID")  
//						})
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "STUDENT_ROLE", 
//				joinColumns = { 
//						@JoinColumn(name = "STUDENT_ID", referencedColumnName = "id") 
//						}, 
//				inverseJoinColumns = {
//						@JoinColumn(name = "ROLE_ID", referencedColumnName = "id")  
//						})
//	private Set<Role> role;


}
