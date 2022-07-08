package com.project.censusprofiling.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.censusprofiling.entity.ApplicationEntity;
import com.project.censusprofiling.exception.ApplicationAlreadyExistsException;
import com.project.censusprofiling.exception.ApplicationNotFoundException;
import com.project.censusprofiling.service.IApplicationService;


@ExtendWith(MockitoExtension.class)
class ApplicationTests {

	@Mock
	IApplicationService iApplicationService;

	@Test
	void addApplicationTest() throws ApplicationAlreadyExistsException {
		ApplicationEntity applicationEntity = new ApplicationEntity(1,"pending",2);
		when(iApplicationService.addApplication(applicationEntity)).thenReturn(applicationEntity);
		assertEquals(iApplicationService.addApplication(applicationEntity),applicationEntity);
	}
	
	@Test
	void getApplicationTest() throws ApplicationNotFoundException {
		ApplicationEntity applicationEntity = new ApplicationEntity(1,"pending",2);
		Optional<ApplicationEntity> OApplicationEntity = Optional.of(applicationEntity);
		when(iApplicationService.getApplication(1)).thenReturn(OApplicationEntity);
		assertEquals(iApplicationService.getApplication(1).get(),applicationEntity);
	}
	
	@Test
	void updateApplicationTest() throws ApplicationNotFoundException {
		ApplicationEntity applicationEntity = new ApplicationEntity(1,"pending",2);
		when(iApplicationService.updateApplication(1,applicationEntity)).thenReturn(applicationEntity);
		assertEquals(iApplicationService.updateApplication(1,applicationEntity),applicationEntity);
	}
	
	@Test
	void deleteApplicationTest() throws ApplicationNotFoundException {
		ApplicationEntity applicationEntity = new ApplicationEntity(1,"pending",2);
		Optional<ApplicationEntity> OApplicationEntity = Optional.of(applicationEntity);
		when(iApplicationService.deleteApplication(1)).thenReturn(OApplicationEntity);
		assertEquals(iApplicationService.deleteApplication(1).get(),applicationEntity);
	}

}
