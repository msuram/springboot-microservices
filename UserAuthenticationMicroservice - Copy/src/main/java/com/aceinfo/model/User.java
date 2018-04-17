package com.aceinfo.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user", schema = "aceinfo")
//@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_id", unique=true, nullable=false)
	private Integer userId;

	@Column(name="created_by", nullable=false, length=30)
	private String createdBy;

	@Column(name="created_on")
	private Timestamp createdOn;

	@Column(name="updated_by", nullable=false, length=30)
	private String updatedBy;

	@Column(name="updated_on", nullable=false)
	private Timestamp updatedOn;

	@Column(name="user_email", nullable=false, length=50)
	private String userEmail;

	@Column(name="user_firstname", nullable=false, length=20)
	private String userFirstname;

	@Column(name="user_lastname", nullable=false, length=20)
	private String userLastname;

	@Column(name="user_login", nullable=false, length=30)
	private String userLogin;

	@Column(name="user_enc_password", nullable=false, length=255)
	private String userPassword;

	@Column(name="user_status")
	private Boolean userStatus;

	//bi-directional many-to-one association to Userrole
	@OneToMany(mappedBy="user",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Userrole> userroles;

	public User() {
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getUpdatedOn() {
		return this.updatedOn;
	}

	public void setUpdatedOn(Timestamp updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserFirstname() {
		return this.userFirstname;
	}

	public void setUserFirstname(String userFirstname) {
		this.userFirstname = userFirstname;
	}

	public String getUserLastname() {
		return this.userLastname;
	}

	public void setUserLastname(String userLastname) {
		this.userLastname = userLastname;
	}

	public String getUserLogin() {
		return this.userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Boolean getUserStatus() {
		return this.userStatus;
	}

	public void setUserStatus(Boolean userStatus) {
		this.userStatus = userStatus;
	}

	public List<Userrole> getUserroles() {
		return this.userroles;
	}

	public void setUserroles(List<Userrole> userroles) {
		this.userroles = userroles;
	}

	public Userrole addUserrole(Userrole userrole) {
		getUserroles().add(userrole);
		userrole.setUser(this);

		return userrole;
	}

	public Userrole removeUserrole(Userrole userrole) {
		getUserroles().remove(userrole);
		userrole.setUser(null);

		return userrole;
	}

}