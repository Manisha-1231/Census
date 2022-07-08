package com.project.censusprofiling.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.censusprofiling.entity.MemberEntity;
import com.project.censusprofiling.entity.UserEntity;
import com.project.censusprofiling.exception.UserAlreadyExistsException;
import com.project.censusprofiling.exception.UserNotFoundException;
import com.project.censusprofiling.service.IMemberService;
import com.project.censusprofiling.service.IUserService;

@RestController
public class UserController {

	// to injuct the fields ,constructors
	@Autowired
	private IUserService iUserService;

	@Autowired
	private IMemberService iMemberService;

	// to get the all the details
	@GetMapping("/user")
	public List<UserEntity> getAllUsers() {
		return iUserService.getAllUsers();
	}

	// to get the details by using userId
	// Optional is return type like string,int
	@GetMapping("/user/{id}")
	public Optional<UserEntity> getUser(@PathVariable int id) throws UserNotFoundException {
		return iUserService.getUser(id);
	}

	// to get the details by using first name
	@GetMapping("/getMemberByFirstName/{firstName}")
	public List<MemberEntity> getByName(@PathVariable String firstName) throws UserNotFoundException {
		return iMemberService.findByFname(firstName);
	}

	// to get the details by using last name
	@GetMapping("/getMemberByLastName/{LastName}")
	public List<MemberEntity> getUserByLname(@PathVariable String LastName) throws UserNotFoundException {
		return iMemberService.findByLname(LastName);
	}

	// to get the details by using date of birth
	@GetMapping("/getMemberByDOB/{dob}")
	public List<MemberEntity> getUserByDOB(@PathVariable String dob) throws UserNotFoundException {
		return iMemberService.findByDob(LocalDate.parse(dob));
	}

	// to get the details by using applicationId
	@GetMapping("/getUserByApplicationId/{id}")
	public Optional<UserEntity> getUserByApplicationId(@PathVariable int id) throws Exception {
		return iUserService.findByApplicationId(id);
	}

	// to get the details by using applicationStatus
	@GetMapping("/getUserByApplicationStatus/{status}")
	public List<UserEntity> getUserByApplicationStatus(@PathVariable String status) throws Exception {
		return iUserService.findByApplicationStatus(status);
	}

	// to post the values from the database
	// @RequestBody is used for to display the output on body
	@PostMapping("/user")
	public UserEntity addUser(@Valid @RequestBody UserEntity userEntity) throws UserAlreadyExistsException {
		return iUserService.addUser(userEntity);
	}

	// to delete the particular column by using userId
	@DeleteMapping("/user/{id}")
	public Optional<UserEntity> deleteUser(@PathVariable int id) throws UserNotFoundException {
		return iUserService.deleteUser(id);
	}

	// to put the values by using userId
	@PutMapping("/user/{id}")
	public UserEntity updateUser(@PathVariable int id, @Valid @RequestBody UserEntity userEntity)
			throws UserNotFoundException {
		return iUserService.updateUser(id, userEntity);
	}
}
