package com.sopra.formacion.servicio;

import java.util.List;
import com.sopra.formacion.form.Contact;

public interface ContactoService {

 public void addContact(Contact contacto);
 
 
public List<Contact> listContact();
 
 
 public void removeContact(Integer id);
}