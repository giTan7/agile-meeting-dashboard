package com.meeting.dashboard.service;

import java.util.List;

import com.meeting.dashboard.model.Meeting;

public interface MeetingService {

	public Meeting saveMeeting(Meeting m);
	public Meeting getMeeting(Long id);
	public List<Meeting> getMeetingList();

}
