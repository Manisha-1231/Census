package com.project.censusprofiling.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.censusprofiling.entity.ApplicationEntity;

@Repository
public interface IApplicationRepo extends JpaRepository<ApplicationEntity, Integer> {

	List<ApplicationEntity> findByStatus(String status);

}
