package com.meeting.dashboard.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.meeting.dashboard.model.Member;
import com.meeting.dashboard.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	public List<Member> getMemberList() {
		List<Member> dummyDataList = new ArrayList<>();
		dummyDataList.add(new Member(1,"john", "john@abc.com"));
		dummyDataList.add(new Member(2,"smith", "smith@abc.com"));
		dummyDataList.add(new Member(3,"curl", "curl@abc.com"));
		return dummyDataList;
	}

}
