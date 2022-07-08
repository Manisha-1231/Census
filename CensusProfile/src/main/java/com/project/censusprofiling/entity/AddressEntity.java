package com.project.censusprofiling.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name="address_data")
@Data
public class AddressEntity {

	//fields
	@Id
	@Min(1)
	private int id;//primary key
	
	@NotNull(message = "d_no is mandatory")
	private String dNo;

	@NotNull(message = "street is mandatory")
	private String street;

	@NotNull(message = "city is mandatory")
	private String city;
	
	@NotNull(message = "state is mandatory")
	private String state; 	
	
	@Size(min = 6, max = 6, message ="pincode should be of size 6")
	@NotNull(message = "pincode is mandatory")
	private String pincode;
	
	public AddressEntity() {
		super();
	}

	public AddressEntity(@Min(1) int id, @NotNull(message = "d_no is mandatory") String d_no,
			@NotNull(message = "street is mandatory") String street,
			@NotNull(message = "city is mandatory") String city, @NotNull(message = "state is mandatory") String state,
			@Size(min = 6, max = 6, message = "pincode should be of size 6") @NotNull(message = "pincode is mandatory") String pincode) {
		super();
		this.id = id;
		this.dNo = d_no;
		this.street = street;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}	
}
