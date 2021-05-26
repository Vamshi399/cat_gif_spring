package com.crud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER_TBL")
public class User {

    @Id
    @Column(unique = true)
    private int userid;
    
    @OneToMany(targetEntity = Cat.class, mappedBy = "user", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Cat> cats;

	public List<Cat> getCats() {
		return cats;
	}

	public void setCats(ArrayList<Cat> cats) {
		this.cats = cats;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	
}
