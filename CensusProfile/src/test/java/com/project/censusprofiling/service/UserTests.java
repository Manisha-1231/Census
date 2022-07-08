package com.project.censusprofiling.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.censusprofiling.entity.UserEntity;
import com.project.censusprofiling.exception.UserAlreadyExistsException;
import com.project.censusprofiling.exception.UserNotFoundException;
import com.project.censusprofiling.service.IUserService;

@ExtendWith(MockitoExtension.class)
public class UserTests {

	@Mock
	IUserService iUserService;

	@Test
	void addUserTest() throws UserAlreadyExistsException {
		UserEntity userEntity = new UserEntity(1,"name1","name2",LocalDate.parse("2022-12-12"),"qwerty@qaz.com","8790012308","qwerty");
		when(iUserService.addUser(userEntity)).thenReturn(userEntity);
		assertEquals(iUserService.addUser(userEntity),userEntity);
	}
	
	@Test
	void getUserTest() throws UserNotFoundException {
		UserEntity userEntity = new UserEntity(1,"name1","name2",LocalDate.parse("2022-12-12"),"qwerty@qaz.com","8790012308","qwerty");
		Optional<UserEntity> OUserEntity = Optional.of(userEntity);
		when(iUserService.getUser(1)).thenReturn(OUserEntity);
		assertEquals(iUserService.getUser(1).get(),userEntity);
	}
	
	@Test
	void updateUserTest() throws UserNotFoundException {
		UserEntity userEntity = new UserEntity(1,"name1","name2",LocalDate.parse("2022-12-12"),"qwerty@qaz.com","8790012308","qwerty");
		when(iUserService.updateUser(1,userEntity)).thenReturn(userEntity);
		assertEquals(iUserService.updateUser(1,userEntity),userEntity);
	}
	
	@Test
	void deleteUserTest() throws UserNotFoundException {
		UserEntity userEntity = new UserEntity(1,"name1","name2",LocalDate.parse("2022-12-12"),"qwerty@qaz.com","8790012308","qwerty");
		Optional<UserEntity> OUserEntity = Optional.of(userEntity);
		when(iUserService.deleteUser(1)).thenReturn(OUserEntity);
		assertEquals(iUserService.deleteUser(1).get(),userEntity);
	}

}

