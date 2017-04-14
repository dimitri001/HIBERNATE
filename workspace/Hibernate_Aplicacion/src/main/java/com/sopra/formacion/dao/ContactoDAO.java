package com.sopra.formacion.dao;


import java.util.List;
import com.sopra.formacion.form.Contact;

public interface ContactoDAO {

	
public void addContact(Contact contacto);


public List<Contact> listContact();


public void removeContact(Integer id);


}