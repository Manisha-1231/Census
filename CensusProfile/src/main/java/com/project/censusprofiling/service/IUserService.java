package com.project.censusprofiling.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.censusprofiling.entity.UserEntity;
import com.project.censusprofiling.exception.UserAlreadyExistsException;
import com.project.censusprofiling.exception.UserNotFoundException;

@Service
public interface IUserService {

	//to get all the user details
	public List<UserEntity> getAllUsers();

	//to get the details user details by using userId
	public Optional<UserEntity> getUser(int id) throws UserNotFoundException;
	
	//to add the user details
	public UserEntity addUser(UserEntity userEntity) throws UserAlreadyExistsException;

	//to delete the particular column by using userId
	public Optional<UserEntity> deleteUser(int id) throws UserNotFoundException;

	//to update the particular column by using userId
	public UserEntity updateUser(int id, UserEntity userEntity) throws UserNotFoundException;

	//to get the details by using applicationId
	public Optional<UserEntity> findByApplicationId(int id) throws Exception;

	//to get the details by using applicationStatus
	public List<UserEntity> findByApplicationStatus(String status) throws Exception;

}
