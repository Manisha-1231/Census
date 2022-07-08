package com.project.censusprofiling.service;

import java.util.List;
import java.util.Optional;

import com.project.censusprofiling.entity.ApplicationEntity;
import com.project.censusprofiling.exception.ApplicationAlreadyExistsException;
import com.project.censusprofiling.exception.ApplicationNotFoundException;

public interface IApplicationService {

	// to get the all application details
	public List<ApplicationEntity> getAllApplications();

	// to get the details by using applicationId
	public Optional<ApplicationEntity> getApplication(int id) throws ApplicationNotFoundException;

	// to add the application
	public ApplicationEntity addApplication(ApplicationEntity applicationEntity)
			throws ApplicationAlreadyExistsException;

	// to delete the particular column by using applicationId
	public Optional<ApplicationEntity> deleteApplication(int id) throws ApplicationNotFoundException;

	// to update the application details by using applicationId
	public ApplicationEntity updateApplication(int id, ApplicationEntity applicationEntity)
			throws ApplicationNotFoundException;

}
