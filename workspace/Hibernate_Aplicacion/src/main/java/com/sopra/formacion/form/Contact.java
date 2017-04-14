package com.sopra.formacion.form;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *  @Entity le decimos a Hibernate que esta clase representa un objeto persistente.
 *	
 *  @Table(name="CONTACTOS") le dice que la tabla que tiene que utilizar para mapear los objetos de esta
 *  clase  es CONTACOTS.
 *  
 *  @Id es una notaci�n que indica que la variable Id es la clave primaia de la tabla
 *  
 *  @GeneratedValude indica que el valor se lo dará la BD y no se hará en el código, es 
 *   decir será un valor autogenerado.
 *  
 *  @Column (name="nombre")  es una notación que se utiliza para asignar la 
 *   propiedad a la columna de la base de datos.
 * 
 * @author jmsanjuan
 *
 */
@Entity
@Table(name="CONTACTS")
public class Contact {
	
	 @Id
	    @Column(name="ID")
	    @GeneratedValue
	    private Integer id;
	     
	    @Column(name="FIRSTNAME")
	    private String firstname;
	 
	    @Column(name="LASTNAME")
	    private String lastname;
	 
	    @Column(name="EMAIL")
	    private String email;
	     
	    @Column(name="TELEPHONE")
	    private String telephone;
	     
	     
	    public String getEmail() {
	        return email;
	    }
	    public String getTelephone() {
	        return telephone;
	    }
	    public void setEmail(String email) {
	        this.email = email;
	    }
	    public void setTelephone(String telephone) {
	        this.telephone = telephone;
	    }
	    public String getFirstname() {
	        return firstname;
	    }
	    public String getLastname() {
	        return lastname;
	    }
	    public void setFirstname(String firstname) {
	        this.firstname = firstname;
	    }
	    public void setLastname(String lastname) {
	        this.lastname = lastname;
	    }
	    public Integer getId() {
	        return id;
	    }
	    public void setId(Integer id) {
	        this.id = id;
	    }

}
