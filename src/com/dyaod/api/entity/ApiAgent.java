package com.dyaod.api.entity;

import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotBlank;
import org.springside.modules.persistence.Hibernates;

import com.dyaod.api.APIConstant;
import com.dyaod.sys.entity.User;

@Entity
@Table(name = "API_AGENT")
public class ApiAgent {

	private Long id;
	private String name;
    private String param;
    private String result;
	private String type;
	private String description;
	private String example;
	private User user;
	private DateTime updateTime;
	private String status = APIConstant.STATUS.未测试.name();
    private String supportAndroid = APIConstant.ANDROID.ALL.name();
    private boolean needRoot = false;
    private String exception;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@NotBlank
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

    public String getSupportAndroid() {
        return supportAndroid;
    }

    public void setSupportAndroid(String supportAndroid) {
        this.supportAndroid = supportAndroid;
    }

    public boolean isNeedRoot() {
        return needRoot;
    }

    public void setNeedRoot(boolean needRoot) {
        this.needRoot = needRoot;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
