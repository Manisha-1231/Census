package com.project.censusprofiling.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.censusprofiling.entity.AddressEntity;
import com.project.censusprofiling.exception.AddressAlreadyExistsException;
import com.project.censusprofiling.exception.AddressNotFoundException;
import com.project.censusprofiling.repository.IAddressRepo;

@Service
public class AddressServiceImpl implements IAddressService {

	// logger is similar to printing statement and print error response
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	// to injuct the dependency
	@Autowired
	private IAddressRepo iAddressRepo;

	// to print list of address
	@Override
	public List<AddressEntity> getAllAddresss() {
		return iAddressRepo.findAll();
	}

	// to print addrress details by using addressId
	@Override
	public Optional<AddressEntity> getAddress(int id) throws AddressNotFoundException {
		Optional<AddressEntity> addressData = iAddressRepo.findById(id);
		if (!addressData.isEmpty()) {
			return iAddressRepo.findById(id);
		} else {
			LOGGER.error("Address Not Found in getAddress");
			throw new AddressNotFoundException("Address Not Found with id " + id);
		}
	}

	// to add the values in the address table
	@Override
	public AddressEntity addAddress(AddressEntity addressEntity) throws AddressAlreadyExistsException {
		Optional<AddressEntity> addressData = iAddressRepo.findById(addressEntity.getId());
		if (addressData.isEmpty()) {
			return iAddressRepo.save(addressEntity);
		} else {
			LOGGER.error("Address already Found in addAddress");
			throw new AddressAlreadyExistsException("Address already exists with id " + addressEntity.getId());
		}
	}

	// to delete the address entity by using addressId
	@Override
	public Optional<AddressEntity> deleteAddress(int id) throws AddressNotFoundException {
		Optional<AddressEntity> addressData = iAddressRepo.findById(id);
		if (!addressData.isEmpty()) {
			iAddressRepo.deleteById(id);
			return addressData;
		} else {
			LOGGER.error("Address Not Found in deleteAddress");
			throw new AddressNotFoundException("Address Not Found with id " + id);
		}
	}

	// to update the address by using addressId
	@Override
	public AddressEntity updateAddress(int id, AddressEntity addressEntity) throws AddressNotFoundException {
		Optional<AddressEntity> addressData = iAddressRepo.findById(id);
		if (!addressData.isEmpty()) {
			addressEntity.setId(id);
			return iAddressRepo.save(addressEntity);
		} else {
			LOGGER.error("Address Not Found in updateAddress");
			throw new AddressNotFoundException("Address Not Found with id " + id);
		}
	}
}
