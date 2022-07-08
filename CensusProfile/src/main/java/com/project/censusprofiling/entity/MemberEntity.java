package com.project.censusprofiling.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "member_data")
@Data
public class MemberEntity {

	// fields
	@Id
	@Min(1)
	private int id;// primary key

	@Size(min = 1, max = 32, message = "firstName length cannot be more than 32")
	@NotNull(message = "firstName is mandatory")
	private String firstName;

	@Size(min = 1, max = 32, message = "lastName length cannot be more than 32")
	@NotNull(message = "lastName is mandatory")
	private String lastName;

	@NotNull(message = "DOB is mandatory")
	private LocalDate DOB;

	@NotNull(message = "gender is mandatory")
	private String gender;

	@NotNull(message = "relationShip is mandatory")
	private String relationShip;

	@NotNull(message = "marital_status is mandatory")
	private String qualification;

	@NotNull(message = "marital_status is mandatory")
	private String marital_status;

	// one member can map with one address
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private AddressEntity addressEntity;

	public MemberEntity() {
		super();
	}

	public MemberEntity(@Min(1) int id,
			@Size(min = 1, max = 32, message = "firstName length cannot be more than 32") @NotNull(message = "firstName is mandatory") String firstName,
			@Size(min = 1, max = 32, message = "lastName length cannot be more than 32") @NotNull(message = "lastName is mandatory") String lastName,
			@NotNull(message = "DOB is mandatory") LocalDate dOB,
			@NotNull(message = "gender is mandatory") String gender,
			@NotNull(message = "relationShip is mandatory") String relationShip,
			@NotNull(message = "marital_status is mandatory") String qualification,
			@NotNull(message = "marital_status is mandatory") String marital_status) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		DOB = dOB;
		this.gender = gender;
		this.relationShip = relationShip;
		this.qualification = qualification;
		this.marital_status = marital_status;
	}
}
