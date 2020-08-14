package com.meeting.dashboard.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="meeting")
@Data
public class Meeting {

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	@Column(name = "title")
	private String meetingTitle;

	@Column(name = "notes")
	private String meetingNotes;

	@Column(name = "start_time")
	private Date meetingStartTime;

	@Column(name = "end_time")
	private Date meetingEndTime;

	@Column(name = "meeting_link")
	private String meetingLink;

	@Column(name = "organizer")
	private User meetingOrganizer;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "meeting_users",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "meeting_id", referencedColumnName = "id"))
	private List<User> meetingMembers;

}
