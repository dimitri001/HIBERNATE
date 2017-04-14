package com.sopra.formacion.controller;

import java.util.Map;

import com.sopra.formacion.servicio.ContactoService;

import com.sopra.formacion.form.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContactoController {

@Autowired

private ContactoService contactService;




@RequestMapping("/")
public String listContacts(Map<String, Object> map) {
	map.put("contact", new Contact());
	map.put("contactList", contactService.listContact());

return "contact";
}


@RequestMapping(value = "/add", method = RequestMethod.POST)
public String addContact(@ModelAttribute("contact")
Contact contact, BindingResult result) {
contactService.addContact(contact);
return "redirect:/";
 }


@RequestMapping("/delete/{contactId}")
public String deleteContact(@PathVariable("contactId")
  Integer contactId) {
  contactService.removeContact(contactId);
  return "redirect:/";
 }
}


