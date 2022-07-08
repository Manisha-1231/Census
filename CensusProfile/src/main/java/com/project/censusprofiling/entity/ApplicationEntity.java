package com.project.censusprofiling.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Data;

@Entity
@Table(name="application_data")
@Data
public class ApplicationEntity {
	
	//fields
	//@Id means to provide the primary key values
	@Id
	@Min(1)
	private int id;//primary key
	
	@NotNull(message = "status is mandatory")
	private String status;
	
	@Positive (message = "user_id should be greater than 0")
	private int  userId;

	public ApplicationEntity(@Min(1) int id, @NotNull(message = "status is mandatory") String status,
			@Positive(message = "user_id should be greater than 0") int userId) {
		super();
		this.id = id;
		this.status = status;
		this.userId = userId;
	}
}
