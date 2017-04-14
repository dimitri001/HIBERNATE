package com.sopra.formacion.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sopra.formacion.dao.ContactoDAO;
import com.sopra.formacion.form.Contact;


@Service
public class ContactoServiceImpl implements ContactoService {

 @Autowired
 private ContactoDAO contactDAO;

 @Transactional
 public void addContact(Contact contacto) {
	 contactDAO.addContact(contacto);
 }

 @Transactional
 public List<Contact> listContact() {

 return contactDAO.listContact();
 }

 @Transactional
 public void removeContact(Integer id) {
	 contactDAO.removeContact(id);
 }
}