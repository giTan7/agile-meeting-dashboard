package com.meeting.dashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meeting.dashboard.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername( String username );
}
