package com.project.censusprofiling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.censusprofiling.entity.UserEntity;

//to access the data directly in database
@Repository
public interface IUserRepo extends JpaRepository<UserEntity, Integer> {

}
