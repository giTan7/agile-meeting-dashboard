package com.meeting.dashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meeting.dashboard.model.Meeting;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {

}
