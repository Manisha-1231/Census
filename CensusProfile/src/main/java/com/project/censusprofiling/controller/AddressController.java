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

import com.project.censusprofiling.entity.AddressEntity;
import com.project.censusprofiling.exception.AddressAlreadyExistsException;
import com.project.censusprofiling.exception.AddressNotFoundException;
import com.project.censusprofiling.service.IAddressService;

@RestController
public class AddressController {

	// to injuct the dependency
	@Autowired
	private IAddressService iAddressService;

	// to get the details
	@GetMapping("/address")
	public List<AddressEntity> getAllAddresss() {
		return iAddressService.getAllAddresss();
	}

	// to get the details by using addressId
	@GetMapping("/address/{id}")
	public Optional<AddressEntity> getAddress(@PathVariable int id) throws AddressNotFoundException {
		return iAddressService.getAddress(id);
	}

	// to add the address details
	@PostMapping("/address")
	public AddressEntity addAddress(@Valid @RequestBody AddressEntity addressEntity)
			throws AddressAlreadyExistsException {
		return iAddressService.addAddress(addressEntity);
	}

	// to delete the particular column by using addressId
	@DeleteMapping("/address/{id}")
	public Optional<AddressEntity> deleteAddress(@PathVariable int id) throws AddressNotFoundException {
		return iAddressService.deleteAddress(id);
	}

	// to update the address by using addressId
	@PutMapping("/address/{id}")
	public AddressEntity updateAddress(@PathVariable int id, @Valid @RequestBody AddressEntity addressEntity)
			throws AddressNotFoundException {
		return iAddressService.updateAddress(id, addressEntity);
	}
}
