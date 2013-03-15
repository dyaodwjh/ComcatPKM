package com.dyaod.api.entity;

import java.util.ArrayList;
import org.joda.time.DateTime;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "API_IDE")
public class ApiIde {

	private Long id;
	private String name;
	private String type;
	private String description;
	private String example;
	private User user;
	private DateTime updateTime;
	private List<ApiAgent> agentList = new ArrayList<ApiAgent>();
	private String status;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	@JoinTable(name="API_IDE_AGENT", joinColumns={@JoinColumn(name="ide_id")},  inverseJoinColumns={@JoinColumn(name="agent_id")})  
	public List<ApiAgent> getAgentList() {
		return agentList;
	}
	public void setAgentList(List<ApiAgent> agentList) {
		this.agentList = agentList;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
