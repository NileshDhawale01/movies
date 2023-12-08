package com.nsd.movies.repositoryes;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nsd.movies.entities.UserInfo;

public interface UserInfoRepo extends JpaRepository<UserInfo, Integer>{

	Optional<UserInfo> findByName(String name);
}
