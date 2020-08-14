package com.meeting.dashboard.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meeting.dashboard.model.Meeting;
import com.meeting.dashboard.repository.MeetingRepository;
import com.meeting.dashboard.service.MeetingService;

@Service
public class MeetingServiceImpl implements MeetingService {

	@Autowired
	private MeetingRepository meetingRepository;

	public List<Meeting> getMeetingList() {
		return meetingRepository.findAll();
	}

	@Override
	public Meeting saveMeeting(Meeting m) {
		if(m.getMeetingStartTime()==null || m.getMeetingEndTime()==null) {
			throw new RuntimeException("Meeting time cannot be null");
		}
		if(m.getMeetingLink() == null) {
			throw new RuntimeException("please provide meeting link");
		}
		if(m.getMeetingMembers().size() <=1) {
			throw new RuntimeException("No members added! Please add members");
		}

//		m.setMeetingOrganizer(loggedInUser);
		//Auto generate it
		m.setMeetingTitle("Sprint Planning");
		return meetingRepository.save(m);
	}

	@Override
	public Meeting getMeeting(Long id) {
		return meetingRepository.findById(id).orElse(null);
	}

}
