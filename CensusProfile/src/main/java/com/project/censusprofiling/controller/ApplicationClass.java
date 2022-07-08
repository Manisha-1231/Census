package com.project.censusprofiling.controller;

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

import com.project.censusprofiling.entity.ApplicationEntity;
import com.project.censusprofiling.exception.ApplicationAlreadyExistsException;
import com.project.censusprofiling.exception.ApplicationNotFoundException;
import com.project.censusprofiling.service.IApplicationService;

@RestController
public class ApplicationClass {

	@Autowired
	private IApplicationService iApplicationService;

	//to get list of application details
	@GetMapping("/application")
	public List<ApplicationEntity> getAllApplications() {
		return iApplicationService.getAllApplications();
	}

	//to get the application details by using applicationId
	@GetMapping("/application/{id}")
	public Optional<ApplicationEntity> getApplication(@PathVariable int id) throws ApplicationNotFoundException {
		return iApplicationService.getApplication(id);
	}

	//to add the details in the application 
	@PostMapping("/application")
	public ApplicationEntity addApplication(@Valid @RequestBody ApplicationEntity applicationEntity)
			throws ApplicationAlreadyExistsException {
		return iApplicationService.addApplication(applicationEntity);
	}

	//to delete the particular column by using applicationId
	@DeleteMapping("/application/{id}")
	public Optional<ApplicationEntity> deleteApplication(@PathVariable int id) throws ApplicationNotFoundException {
		return iApplicationService.deleteApplication(id);
	}

	//to update the particular column by using applicationId
	@PutMapping("/application/{id}")
	public ApplicationEntity updateApplication(@PathVariable int id,
			@Valid @RequestBody ApplicationEntity applicationEntity) throws ApplicationNotFoundException {
		return iApplicationService.updateApplication(id, applicationEntity);
	}

}
