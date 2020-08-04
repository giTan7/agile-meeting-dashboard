package com.meeting.dashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meeting.dashboard.model.Meeting;
import com.meeting.dashboard.service.MeetingService;

@RestController
public class MeetingController {

	@Autowired
	private MeetingService meetingService;

	@RequestMapping(value = "/getMeetingList", method = RequestMethod.GET)
	public List<Meeting> getMeetingList() {
		return meetingService.getMeetingList();
	}

}
