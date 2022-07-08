package com.project.censusprofiling.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.censusprofiling.entity.MemberEntity;
import com.project.censusprofiling.exception.MemberAlreadyExistsException;
import com.project.censusprofiling.exception.MemberNotFoundException;
import com.project.censusprofiling.service.IMemberService;

@ExtendWith(MockitoExtension.class)
public class MemberTests {
	

	@Mock
	IMemberService iMemberService;

	@Test
	void addMemberTest() throws MemberAlreadyExistsException {
		LocalDate localDate = LocalDate.of( 2012 , 12 , 7 );
		MemberEntity memberEntity = new MemberEntity(1,"name1","name2",localDate,"male","brother","Graduated","single");
		when(iMemberService.addMember(memberEntity)).thenReturn(memberEntity);
		assertEquals(iMemberService.addMember(memberEntity),memberEntity);
	}
	
	@Test
	void getMemberTest() throws MemberNotFoundException {
		LocalDate localDate = LocalDate.of( 2012 , 12 , 7 );
		MemberEntity memberEntity = new MemberEntity(1,"name1","name2",localDate,"male","brother","Graduated","single");
		Optional<MemberEntity> OMemberEntity = Optional.of(memberEntity);
		when(iMemberService.getMember(1)).thenReturn(OMemberEntity);
		assertEquals(iMemberService.getMember(1).get(),memberEntity);
	}
	
	@Test
	void updateMemberTest() throws MemberNotFoundException {
		LocalDate localDate = LocalDate.of( 2012 , 12 , 7 );
		MemberEntity memberEntity = new MemberEntity(1,"name1","name2",localDate,"male","brother","Graduated","single");
		when(iMemberService.updateMember(1,memberEntity)).thenReturn(memberEntity);
		assertEquals(iMemberService.updateMember(1,memberEntity),memberEntity);
	}
	
	@Test
	void deleteMemberTest() throws MemberNotFoundException {
		LocalDate localDate = LocalDate.of( 2012 , 12 , 7 );
		MemberEntity memberEntity = new MemberEntity(1,"name1","name2",localDate,"male","brother","Graduated","single");
		Optional<MemberEntity> OMemberEntity = Optional.of(memberEntity);
		when(iMemberService.deleteMember(1)).thenReturn(OMemberEntity);
		assertEquals(iMemberService.deleteMember(1).get(),memberEntity);
	}

}
