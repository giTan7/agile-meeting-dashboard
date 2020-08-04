package com.meeting.dashboard.model;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Meeting {
	
	private int Id;
	private String meetingTitle;
	private String meetingNotes;
	private Date meetingStartTime;
	private Date meetingEndTime;
	private String meetingLink;
	private Member meetingOrganizer;
	private List<Member> meetingMembers;
}
