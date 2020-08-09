package com.meeting.dashboard.service;

import java.util.List;

import com.meeting.dashboard.model.User;

public interface UserService {
    User findById(Long id);
    User findByUsername(String username);
    List<User> findAll ();
    User saveUserDetail(User userDetails);
    String removeUser(User userDetails);
}
