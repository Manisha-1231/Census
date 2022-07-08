package com.project.censusprofiling.entity;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "user_data")
@Data
public class UserEntity {

	// fields
	@Id
	@Min(1)
	private int id; // primary key

	@Size(min = 1, max = 32, message = "firstName length cannot be more than 32")
	@NotNull(message = "firstName is mandatory")
	private String firstName;

	@Size(min = 1, max = 32, message = "lastName length cannot be more than 32")
	@NotNull(message = "lastName is mandatory")
	private String lastName;

	@NotNull(message = "DOB is mandatory")
	private LocalDate DOB;

	@Email(message = "Email is invalid")
	@NotNull(message = "Email is mandatory")
	private String email;

	@NotNull(message = "contactNo is not mandatory")
	private String contactNo;

	@NotNull(message = "password is mandatory")
	private String password;

	// one member can access one application Id only and mapping with application Id
	// to join the column name application Id
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "applicationId", referencedColumnName = "id")
	private ApplicationEntity applicationEntity;

	// one user can access multiple members
	// to join the column name member Id
	@OneToMany(targetEntity = MemberEntity.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_fk", referencedColumnName = "id")
	private List<MemberEntity> memberList;

	// Empty constructor
	public UserEntity() {
		super();
	}

	// parameter constructor
	public UserEntity(@Min(1) int id,
			@Size(min = 1, max = 32, message = "firstName length cannot be more than 32") @NotNull(message = "firstName is mandatory") String firstName,
			@Size(min = 1, max = 32, message = "lastName length cannot be more than 32") @NotNull(message = "lastName is mandatory") String lastName,
			@NotNull(message = "DOB is mandatory") LocalDate dOB,
			@Email(message = "Email is invalid") @NotNull(message = "Email is mandatory") String email,
			@NotNull(message = "contactNo is mandatory") String contactNo,
			@NotNull(message = "password is mandatory") String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		DOB = dOB;
		this.email = email;
		this.contactNo = contactNo;
		this.password = password;
	}
}
