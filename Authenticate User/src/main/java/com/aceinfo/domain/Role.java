package com.aceinfo.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private String description;
    private Boolean status;
    private Date createdOn;
    private String createdBy;
    private Date modifiedOn;
    private String modifiedBy;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "tag")
    @Column(name = "Value")
    private List<String> tags = new ArrayList<>();

    public Role(int id,String name, String description, Boolean status,Date createdOn,String createdBy, Date modifiedOn,String modifiedBy) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;  
    }

    public Role() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
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
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", createdOn='" + createdOn + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", modifiedOn=" + modifiedOn + '\'' +
                ", modifiedBy='" + modifiedBy +  
                '}';
    }
}
