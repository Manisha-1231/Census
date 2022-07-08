package com.project.censusprofiling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.censusprofiling.entity.AddressEntity;

@Repository
public interface IAddressRepo extends JpaRepository<AddressEntity, Integer> {

}
