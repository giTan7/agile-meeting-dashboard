package com.meeting.dashboard.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meeting.dashboard.model.User;
import com.meeting.dashboard.service.UserService;

@RestController
@RequestMapping( value = "/user", produces = MediaType.APPLICATION_JSON_VALUE )
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping( method = GET, value = "/{userId}" )
	@PreAuthorize("hasRole('ADMIN')")
	public User loadById( @PathVariable Long userId ) {
		return this.userService.findById( userId );
	}

	@RequestMapping( method = GET, value= "/all")
	@PreAuthorize("hasRole('ADMIN')")
	public List<User> loadAll() {
		return this.userService.findAll();
	}

	@RequestMapping( method = RequestMethod.POST, value = "/add" )
	@PreAuthorize("hasRole('ADMIN')")
	public User saveUser( @RequestHeader(value ="authtoken") String authToken, @RequestBody User userDetails ) {
		return this.userService.saveUserDetail(userDetails);
	}

	@RequestMapping( method = RequestMethod.POST, value = "/remove" )
	@PreAuthorize("hasRole('ADMIN')")
	public String removeUser( @RequestHeader(value ="authtoken") String authToken, @RequestBody User userDetails ) {
		return this.userService.removeUser(userDetails);
	}

}
