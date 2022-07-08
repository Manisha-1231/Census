package com.project.censusprofiling.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.censusprofiling.entity.ApplicationEntity;
import com.project.censusprofiling.exception.ApplicationAlreadyExistsException;
import com.project.censusprofiling.exception.ApplicationNotFoundException;
import com.project.censusprofiling.repository.IApplicationRepo;

@Service
public class ApplicationServiceImpl implements IApplicationService {

	// logger is similar to printing statement and print error response
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private IApplicationRepo iApplicationRepo;

	// to print list of applications
	@Override
	public List<ApplicationEntity> getAllApplications() {
		return iApplicationRepo.findAll();
	}

	// to display particular column by using applicationId
	@Override
	public Optional<ApplicationEntity> getApplication(int id) throws ApplicationNotFoundException {
		Optional<ApplicationEntity> applicationData = iApplicationRepo.findById(id);
		if (!applicationData.isEmpty()) {
			return iApplicationRepo.findById(id);
		} else {
			LOGGER.error("Application Not Found in getApplication");
			throw new ApplicationNotFoundException("Application Not Found with id " + id);
		}
	}

	// to add the application details
	@Override
	public ApplicationEntity addApplication(ApplicationEntity applicationEntity)
			throws ApplicationAlreadyExistsException {
		Optional<ApplicationEntity> applicationData = iApplicationRepo.findById(applicationEntity.getId());
		if (applicationData.isEmpty()) {
			return iApplicationRepo.save(applicationEntity);
		} else {
			LOGGER.error("Application already Found in addApplication");
			throw new ApplicationAlreadyExistsException(
					"Application already exists with id " + applicationEntity.getId());
		}
	}

	// to delete the particular controller by using applicationId
	@Override
	public Optional<ApplicationEntity> deleteApplication(int id) throws ApplicationNotFoundException {
		Optional<ApplicationEntity> applicationData = iApplicationRepo.findById(id);
		if (!applicationData.isEmpty()) {
			iApplicationRepo.deleteById(id);
			return applicationData;
		} else {
			LOGGER.error("Application Not Found in deleteApplication");
			throw new ApplicationNotFoundException("Application Not Found with id " + id);
		}
	}

	// to update the application details by using applicationId
	@Override
	public ApplicationEntity updateApplication(int id, ApplicationEntity applicationEntity)
			throws ApplicationNotFoundException {
		Optional<ApplicationEntity> applicationData = iApplicationRepo.findById(id);
		if (!applicationData.isEmpty()) {
			applicationEntity.setId(id);
			return iApplicationRepo.save(applicationEntity);
		} else {
			LOGGER.error("Application Not Found in updateApplication");
			throw new ApplicationNotFoundException("Application Not Found with id " + id);
		}
	}
}
