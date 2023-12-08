package com.nsd.movies.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.nsd.movies.configs.UserInfoDetails;
import com.nsd.movies.entities.UserInfo;
import com.nsd.movies.repositoryes.UserInfoRepo;

@Component
public class UserInfoUserDetailServise implements UserDetailsService {

	@Autowired
	private UserInfoRepo infoRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserInfo> userInfo = infoRepo.findByName(username);
		return userInfo.map(UserInfoDetails::new).orElseThrow(() -> new UsernameNotFoundException(username));
	}

}
