package com.formacion.sopra.springmvc.dao;

import java.util.List;

import com.formacion.sopra.springmvc.model.UserDocument;

public interface UserDocumentDao {

	List<UserDocument> findAll();
	
	UserDocument findById(int id);
	
	void save(UserDocument document);
	
	List<UserDocument> findAllByUserId(int userId);
	
	void deleteById(int id);
}
