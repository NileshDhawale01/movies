package com.nsd.movies.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nsd.movies.entities.UserInfo;
import com.nsd.movies.repositoryes.UserInfoRepo;

@Service
public class UsersServiceImpl {

	@Autowired
	private UserInfoRepo infoRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public UserInfo saveUser(UserInfo info) {
		info.setPassword(encoder.encode(info.getPassword()));
		return infoRepo.save(info);
	}
}
