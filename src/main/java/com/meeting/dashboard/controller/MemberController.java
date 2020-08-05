package com.meeting.dashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meeting.dashboard.model.Member;
import com.meeting.dashboard.service.MemberService;

@RestController
public class MemberController {

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/getAdmin", method = RequestMethod.GET)
	public Member getMember() {
		Member obj = new Member();
		obj.setId(111); obj.setEmailId("admin@gmail.com");obj.setUserName("Admin");
		return obj;
	}

	@RequestMapping(value = "/getMemberList", method = RequestMethod.GET)
	public List<Member> getMemberList() {
		return memberService.getMemberList();
	}

}
