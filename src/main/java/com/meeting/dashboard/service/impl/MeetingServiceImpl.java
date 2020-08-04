package com.meeting.dashboard.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.meeting.dashboard.model.Meeting;
import com.meeting.dashboard.model.Member;
import com.meeting.dashboard.service.MeetingService;

@Service
public class MeetingServiceImpl implements MeetingService {

	public List<Meeting> getMeetingList() {
		Member adminMember = new Member(111, "admin@gmail.com", "Admin");
		List<Member> meetingAttendees = new ArrayList<>();
		meetingAttendees.add(new Member(1,"john", "john@abc.com"));
		meetingAttendees.add(new Member(2,"smith", "smith@abc.com"));

		List<Meeting> dummyMeetingList = new ArrayList<>();
		dummyMeetingList.add(new Meeting(1,"ABC","CN",new Date(8/4/2020), new Date(8/4/2020),"http:google.comm",adminMember,meetingAttendees));
		dummyMeetingList.add(new Meeting(2,"DEF","OS",new Date(8/4/2020), new Date(8/4/2020),"http:yahoo.comm",adminMember,meetingAttendees));
		dummyMeetingList.add(new Meeting(3,"GHI","DBMS",new Date(8/4/2020), new Date(8/4/2020),"http:gigi.comm",adminMember,meetingAttendees));
		return dummyMeetingList;
	}

}
