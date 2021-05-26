package com.crud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CAT_TBL")
public class Cat {

    @Id
    private String id;
    
    private String created_at;
    
    @ElementCollection(targetClass=String.class)
    private List<String> tags;
    
    private String url;
    
    private int userid; 
    
    @ManyToOne(fetch = FetchType.LAZY) //, optional = false
    @JoinColumn(name = "userid", updatable = false, insertable = false) //unique = false, 
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User user;
	
	public String getCreated_at() {
		return created_at;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}

	

	
}
