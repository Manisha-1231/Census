package com.project.censusprofiling.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.censusprofiling.entity.MemberEntity;
import com.project.censusprofiling.exception.MemberAlreadyExistsException;
import com.project.censusprofiling.exception.MemberNotFoundException;
import com.project.censusprofiling.repository.IMemberRepo;

@Service
public class MemberServiceImpl implements IMemberService {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IMemberRepo iMemberRepo;

	// to get all the member details
	@Override
	public List<MemberEntity> getAllMembers() {
		return iMemberRepo.findAll();
	}

	// to get the member details by using memberId
	@Override
	public Optional<MemberEntity> getMember(int id) throws MemberNotFoundException {
		Optional<MemberEntity> memberData = iMemberRepo.findById(id);
		if (!memberData.isEmpty()) {
			return iMemberRepo.findById(id);
		} else {
			LOGGER.error("Member Not Found in getMember");
			throw new MemberNotFoundException("Member Not Found with id " + id);
		}
	}

	// to add the member details
	@Override
	public MemberEntity addMember(MemberEntity memberEntity) throws MemberAlreadyExistsException {
		Optional<MemberEntity> memberData = iMemberRepo.findById(memberEntity.getId());
		if (memberData.isEmpty()) {
			return iMemberRepo.save(memberEntity);
		} else {
			LOGGER.error("Member already Found in addMember");
			throw new MemberAlreadyExistsException("Member already exists with id " + memberEntity.getId());
		}
	}

	// to delete the member details by using memberId
	@Override
	public Optional<MemberEntity> deleteMember(int id) throws MemberNotFoundException {
		Optional<MemberEntity> memberData = iMemberRepo.findById(id);
		if (!memberData.isEmpty()) {
			iMemberRepo.deleteById(id);
			return memberData;
		} else {
			LOGGER.error("Member Not Found in deleteMember");
			throw new MemberNotFoundException("Member Not Found with id " + id);
		}
	}

	// to update the member details by using memberId
	@Override
	public MemberEntity updateMember(int id, MemberEntity memberEntity) throws MemberNotFoundException {
		Optional<MemberEntity> memberData = iMemberRepo.findById(id);
		if (!memberData.isEmpty()) {
			memberEntity.setId(id);
			return iMemberRepo.save(memberEntity);
		} else {
			LOGGER.error("Member Not Found in updateMember");
			throw new MemberNotFoundException("Member Not Found with id " + id);
		}

	}

	// to get the member details by using firstName
	@Override
	public List<MemberEntity> findByFname(String fname) {
		return iMemberRepo.findByFirstName(fname);
	}

	// to get the member details by using lastName
	@Override
	public List<MemberEntity> findByLname(String lname) {
		return iMemberRepo.findByLastName(lname);
	}

	// to get the member details by using date of birth
	@Override
	public List<MemberEntity> findByDob(LocalDate dob) {
		return iMemberRepo.findByDOB(dob);
	}
}
