package com.aceinfo.domain;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String login;
    private String password;
    private boolean status;
    private Date createdOn;
    private String createdBy;
    private Date modifiedOn;
    private String modifiedBy;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "tag")
    @Column(name = "Value")
    private List<String> tags = new ArrayList<>();

    public User(int id,String firstName, String lastName,String email,String login,String password,boolean status,String createdBy,String modifiedBy) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.login = login;
        this.password = password;
        this.status = status;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;  
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }  

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedOn() {
        return createdOn;
    }
    public String getCreatedBy() {
        return createdBy;
    }
    
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }
    public String getModifiedBy() {
        return modifiedBy;
    }
    
    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName ='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", createdOn='" + createdOn + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", modifiedOn=" + modifiedOn + '\'' +
                ", modifiedBy='" + modifiedBy +                 
                '}';
    }
}
