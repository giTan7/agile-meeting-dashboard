package com.meeting.dashboard.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.meeting.dashboard.model.Authority;
import com.meeting.dashboard.model.User;
import com.meeting.dashboard.model.UserRoleName;
import com.meeting.dashboard.repository.UserRepository;
import com.meeting.dashboard.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Override
	public User findByUsername( String username ) throws UsernameNotFoundException {
		User u = userRepository.findByUsername( username );
		return u;
	}

	public User findById( Long id ) throws AccessDeniedException {
		User u = userRepository.findById(id).orElse(new User());
		return u;
	}

	public List<User> findAll() throws AccessDeniedException {
		List<User> result = userRepository.findAll();
		return result;
	}

	@Override
	public User saveUserDetail(User userDetails) {
		if(userDetails.getEmail()==null || userDetails.getEmail().isEmpty()) {
			throw new RuntimeException("Email id cannot be null");
		}
		if(userDetails.getUsername()==null || userDetails.getUsername().isEmpty()) {
			throw new RuntimeException("Username cannot be null");
		}
		if(userDetails.getPassword()==null || userDetails.getPassword().isEmpty()) {
			throw new RuntimeException("Please enter password");
		}
		User existingUser = userRepository.findByUsername(userDetails.getUsername());
		if(existingUser!=null && existingUser.getId() != null) {
			throw new RuntimeException("User exist with provided username");
		}
		List<Authority> authoritites = new ArrayList<>();
		Authority authority = new Authority();
		authority.setName(UserRoleName.ROLE_USER);
		authoritites.add(authority);
		userDetails.setAuthorities(authoritites);
		userDetails.setEnabled(true);
		userDetails.setPassword(passwordEncoder.encode(userDetails.getPassword()));
		return userRepository.save(userDetails);
	}

	@Override
	public String removeUser(User userDetails) {
		if(userDetails==null || userDetails.getId()==null) {
			throw new RuntimeException("User id cannot be null, can't delete the user");
		}
		if(!userRepository.existsById(userDetails.getId())) {
			throw new RuntimeException("User doesn't exist, can't delete");
		}
		userRepository.deleteById(userDetails.getId());
		return "User Deleted";
	}


	@RequestMapping(value = "/change-password", method = RequestMethod.POST)
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> changePassword(@RequestBody PasswordChanger passwordChanger) {
		userDetailsService.changePassword(passwordChanger.oldPassword, passwordChanger.newPassword);
		Map<String, String> result = new HashMap<>();
		result.put("result","success");
		return ResponseEntity.accepted().body(result);
	}

	static class PasswordChanger {
		public String oldPassword;
		public String newPassword;
	}
}
