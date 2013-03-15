package com.dyaod.api.entity;

import java.util.ArrayList;
import org.joda.time.DateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.springside.modules.persistence.Hibernates;

import com.dyaod.sys.entity.User;

@Entity
@Table(name = "API_MODULE")
public class ApiModule {

	private Long id;
	private String name;
	private String type;
	private String description;
	private String example;
	private User user;
	private DateTime updateTime;
	private List<ApiIde> ideList = new ArrayList<ApiIde>();
	private String satus;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(insertable = false, nullable = false, updatable = false)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getExample() {
		return example;
	}
	public void setExample(String example) {
		this.example = example;
	}
	
	@ManyToOne
	@JoinColumn(name="user_id")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@Type(type = Hibernates.DATETIME_TYPE)
	public DateTime getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(DateTime updateTime) {
		this.updateTime = updateTime;
	}
	
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE },fetch = FetchType.LAZY)   
	@JoinTable(name="api_module_ide", joinColumns={@JoinColumn(name="module_id")},  inverseJoinColumns={@JoinColumn(name="ide_id")})  
	public List<ApiIde> getIdeList() {
		return ideList;
	}
	public void setIdeList(List<ApiIde> ideList) {
		this.ideList = ideList;
	}
	public String getSatus() {
		return satus;
	}
	public void setSatus(String satus) {
		this.satus = satus;
	}
	
	
	
}
