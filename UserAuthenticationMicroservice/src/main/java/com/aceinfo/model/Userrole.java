package com.aceinfo.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.sql.Timestamp;


/**
 * The persistent class for the userrole database table.
 * 
 */
@Entity
@Table(name="userrole", schema = "aceinfo")
//@NamedQuery(name="Userrole.findAll", query="SELECT u FROM Userrole u")
public class Userrole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="userrole_id", unique=true, nullable=false)
	private Integer userroleId;

	@Column(name="created_by", nullable=false, length=30)
	private String createdBy;

	@Column(name="created_on")
	private Timestamp createdOn;

	@Column(name="updated_by", nullable=false, length=30)
	private String updatedBy;

	@Column(name="updated_on", nullable=false)
	private Timestamp updatedOn;

	//bi-directional many-to-one association to Role
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonBackReference
	@JoinColumn(name="role_id", nullable = false)
	private Role role;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id", nullable = false)
	private User user;

	public Userrole() {
	}

	public Integer getUserroleId() {
		return this.userroleId;
	}

	public void setUserroleId(Integer userroleId) {
		this.userroleId = userroleId;
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

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}