package com.example.demo.models;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@Table(name = "role", schema = "aceinfo")
//@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="role_id")
	private Integer roleId;

	@Column(name="created_by")
	private String createdBy;

	@Column(name="created_on")
	private Timestamp createdOn;

	@Column(name="role_description")
	private String roleDescription;

	@Column(name="role_name")
	private String roleName;

	@Column(name="role_status")
	private Boolean roleStatus;

	@Column(name="updated_by")
	private String updatedBy;

	@Column(name="updated_on")
	//@Temporal(TemporalType.TIMESTAMP)
	private Timestamp updatedOn;

	//bi-directional many-to-one association to Userrole
	@OneToMany(mappedBy="role", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Userrole> userroles;
	
	public Role() {
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
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

	public String getRoleDescription() {
		return this.roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Boolean getRoleStatus() {
		return this.roleStatus;
	}

	public void setRoleStatus(Boolean roleStatus) {
		this.roleStatus = roleStatus;
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

	public List<Userrole> getUserroles() {
		return this.userroles;
	}

	public void setUserroles(List<Userrole> userroles) {
		this.userroles = userroles;
	}

	public Userrole addUserrole(Userrole userrole) {
		getUserroles().add(userrole);
		userrole.setRole(this);

		return userrole;
	}

	public Userrole removeUserrole(Userrole userrole) {
		getUserroles().remove(userrole);
		userrole.setRole(null);

		return userrole;
	}

}