package com.project.censusprofiling.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.censusprofiling.entity.MemberEntity;
import com.project.censusprofiling.exception.MemberAlreadyExistsException;
import com.project.censusprofiling.exception.MemberNotFoundException;

@Service
public interface IMemberService {

	// to get all the member details
	public List<MemberEntity> getAllMembers();

	// to get the member details by using memberId
	public Optional<MemberEntity> getMember(int id) throws MemberNotFoundException;

	// to add the member details
	public MemberEntity addMember(MemberEntity memberEntity) throws MemberAlreadyExistsException;

	// to delete the particular by using memberId
	public Optional<MemberEntity> deleteMember(int id) throws MemberNotFoundException;

	// to update the member details by using memberId
	public MemberEntity updateMember(int id, MemberEntity memberEntity) throws MemberNotFoundException;

	// to get the all the member details by using firstName
	public List<MemberEntity> findByFname(String fname);

	// to get the all the member details by using lastName
	public List<MemberEntity> findByLname(String lname);

	// to get the all the member details by using date of birth
	public List<MemberEntity> findByDob(LocalDate dob);
}
