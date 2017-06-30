package br.ufg.inf.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * The Class Person.
 */
@Entity
@Table(name = "People")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The person id. */
	private Long personId;
	
	/** The name. */
	private String name;
	
	/** The birth date. */
	private Date birthDate;
	
	/** The id number. */
	private String idNumber;
	
	/** The cpf. */
	private String cpf;
	
	/** The phone number. */
	private String phoneNumber;
	
	/** The email. */
	private String email;

	/**
	 * Gets the person id.
	 *
	 * @return the person id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PERSON_ID")
	public Long getPersonId() {
		return personId;
	}

	/**
	 * Sets the person id.
	 *
	 * @param personId the new person id
	 */
	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the birth date.
	 *
	 * @return the birth date
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * Sets the birth date.
	 *
	 * @param birthDate the new birth date
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * Gets the id number.
	 *
	 * @return the id number
	 */
	public String getIdNumber() {
		return idNumber;
	}

	/**
	 * Sets the id number.
	 *
	 * @param idNumber the new id number
	 */
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	/**
	 * Gets the cpf.
	 *
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * Sets the cpf.
	 *
	 * @param cpf the new cpf
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * Gets the phone number.
	 *
	 * @return the phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets the phone number.
	 *
	 * @param phoneNumber the new phone number
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}
