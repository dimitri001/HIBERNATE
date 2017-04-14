package com.formacion.sopra.springmvc.dao;

import java.util.List;

import com.formacion.sopra.springmvc.model.UserProfile;


public interface UserProfileDao {

	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findById(int id);
}
