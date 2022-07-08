package com.project.censusprofiling.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.censusprofiling.entity.AddressEntity;
import com.project.censusprofiling.exception.AddressAlreadyExistsException;
import com.project.censusprofiling.exception.AddressNotFoundException;

@Service
public interface IAddressService {

	// to get all the details
	public List<AddressEntity> getAllAddresss();

	// to get one address by using addressId
	public Optional<AddressEntity> getAddress(int id) throws AddressNotFoundException;

	// to add the address details
	public AddressEntity addAddress(AddressEntity addressEntity) throws AddressAlreadyExistsException;

	// to delete particular column the addressId
	public Optional<AddressEntity> deleteAddress(int id) throws AddressNotFoundException;

	// to update the address by using addressId
	public AddressEntity updateAddress(int id, AddressEntity addressEntity) throws AddressNotFoundException;
}
