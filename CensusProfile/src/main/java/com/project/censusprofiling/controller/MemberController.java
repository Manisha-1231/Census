package com.project.censusprofiling.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.censusprofiling.entity.MemberEntity;
import com.project.censusprofiling.exception.MemberNotFoundException;
import com.project.censusprofiling.service.IMemberService;

@RestController
public class MemberController {

	//to injuct the dependency like constructor,fields
	@Autowired
	private IMemberService iMemberService;

	//to get all the member details
	@GetMapping("/member")
	public List<MemberEntity> getAllMembers() {
		return iMemberService.getAllMembers();
	}

	// to get the member details by using memberId
	@GetMapping("/member/{id}")
	public Optional<MemberEntity> getMember(@PathVariable int id) throws MemberNotFoundException {
		return iMemberService.getMember(id);
	}

	// to delete the particular column by using memberId
	@DeleteMapping("/member/{id}")
	public Optional<MemberEntity> deleteMember(@PathVariable int id) throws MemberNotFoundException {
		return iMemberService.deleteMember(id);
	}

	//to update the member details by using memberId
	@PutMapping("/member/{id}")
	public MemberEntity updateMember(@PathVariable int id, @Valid @RequestBody MemberEntity memberEntity)
			throws MemberNotFoundException {
		return iMemberService.updateMember(id, memberEntity);
	}

}
