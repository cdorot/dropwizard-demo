package fr.ippon.dropwizard.core;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity(name = User.ENTITY_NAME)
@Table(name = User.ENTITY_NAME)
@NamedQuery(name = "user_findAll", query = "select u from " + User.ENTITY_NAME + " u")
public class User {

	static final String ENTITY_NAME = "users";

	public static final String QUERY_FIND_ALL = "user_findAll";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String firstname;

	private String lastname;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

}
