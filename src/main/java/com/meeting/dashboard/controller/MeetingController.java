package com.meeting.dashboard.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meeting.dashboard.model.Meeting;
import com.meeting.dashboard.service.MeetingService;

@RestController
@RequestMapping( value = "/meeting", produces = MediaType.APPLICATION_JSON_VALUE )
@CrossOrigin(origins = "http://localhost:4200")
public class MeetingController {

	@Autowired
	private MeetingService meetingService;

	@RequestMapping( method = GET, value = "/{id}" )
	@PreAuthorize("hasRole('ADMIN')")
	public Meeting loadById( @PathVariable Long id ) {
		return this.meetingService.getMeeting(id);
	}

	@RequestMapping( method = GET, value= "/all")
	@PreAuthorize("hasRole('ADMIN')")
	public List<Meeting> loadAll() {
		return this.meetingService.getMeetingList();
	}

	@RequestMapping( method = RequestMethod.POST, value = "/add" )
	@PreAuthorize("hasRole('ADMIN')")
	public Meeting saveUser( @RequestHeader(value ="authtoken") String authToken, @RequestBody Meeting meetingDetails ) {
		return this.meetingService.saveMeeting(meetingDetails);
	}

	@RequestMapping(value = "/getMeetingList", method = RequestMethod.GET)
	public List<Meeting> getMeetingList() {
		return meetingService.getMeetingList();
	}

}
