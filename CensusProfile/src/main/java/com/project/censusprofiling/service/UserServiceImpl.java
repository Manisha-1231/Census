package com.project.censusprofiling.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.censusprofiling.entity.ApplicationEntity;
import com.project.censusprofiling.entity.UserEntity;
import com.project.censusprofiling.exception.UserAlreadyExistsException;
import com.project.censusprofiling.exception.UserNotFoundException;
import com.project.censusprofiling.repository.IApplicationRepo;
import com.project.censusprofiling.repository.IUserRepo;

@Service
public class UserServiceImpl implements IUserService {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IUserRepo userRepo;

	// to get all the user details
	@Override
	public List<UserEntity> getAllUsers() {
		LOGGER.info("inside getAllUsers");
		return userRepo.findAll();
	}

	// to get the user details by using userId
	@Override
	public Optional<UserEntity> getUser(int id) throws UserNotFoundException {

		LOGGER.info("inside getUser");
		Optional<UserEntity> userData = userRepo.findById(id);
		if (!userData.isEmpty()) {
			return userRepo.findById(id);
		} else {
			LOGGER.error("User Not Found in getUser");
			throw new UserNotFoundException("User Not Found with id " + id);
		}
	}

	// to add the user details
	@Override
	public UserEntity addUser(UserEntity userEntity) throws UserAlreadyExistsException {
		LOGGER.info("inside addUser");
		Optional<UserEntity> userData = userRepo.findById(userEntity.getId());
		if (userData.isEmpty()) {
			return userRepo.save(userEntity);
		} else {
			LOGGER.error("User already Found in addUser");
			throw new UserAlreadyExistsException("User Already Exists with id " + userEntity.getId());
		}
	}

	// to delete the particular column by using userId
	@Override
	public Optional<UserEntity> deleteUser(int id) throws UserNotFoundException {
		LOGGER.info("inside deleteUser");
		Optional<UserEntity> userData = userRepo.findById(id);
		if (!userData.isEmpty()) {
			userRepo.deleteById(id);
			return userData;
		} else {
			LOGGER.error("User Not Found in deleteUser");
			throw new UserNotFoundException("User Not Found with id " + id);
		}
	}

	// to update the particular column by using userId
	@Override
	public UserEntity updateUser(int id, UserEntity userEntity) throws UserNotFoundException {
		LOGGER.info("inside updateUser");
		Optional<UserEntity> userData = userRepo.findById(id);
		if (!userData.isEmpty()) {
			userEntity.setId(id);
			return userRepo.save(userEntity);
		} else {
			LOGGER.error("User Not Found in updateUser");
			throw new UserNotFoundException("User Not Found with id " + id);
		}
	}

	@Autowired
	IApplicationRepo iApplicationRepo;

	// to get the user details by using applicationId
	@Override
	public Optional<UserEntity> findByApplicationId(int id) throws Exception {

		try {
			Optional<ApplicationEntity> application = iApplicationRepo.findById(id);
			return userRepo.findById(application.get().getUserId());
		} catch (Exception e) {
			throw new Exception("User not found with application id " + id);
		}
	}

	// to get the user details by using applicationStatus
	@Override
	public List<UserEntity> findByApplicationStatus(String status) throws Exception {
		List<UserEntity> userList = new ArrayList<>();
		try {
			List<ApplicationEntity> applications = iApplicationRepo.findByStatus(status);
			for (ApplicationEntity application : applications) {
				try {
					Optional<UserEntity> user = userRepo.findById(application.getUserId());
					userList.add(user.get());
				} catch (Exception e) {

				}
			}
		} catch (Exception e) {
			throw new Exception("no user found with status " + status);
		}
		return userList;
	}

}
