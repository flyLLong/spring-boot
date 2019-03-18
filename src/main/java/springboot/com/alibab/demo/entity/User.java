package springboot.com.alibab.demo.entity;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class User implements Serializable {
	
	private static final long serialVersionUID = -2661607719684530812L;

	private Integer userId;
	
	private String userName;
	
	private String password;

    private String phone;
	
    private Date createTime;
    
    public void setUserId(Integer userId) {
    	this.userId = userId;
    }
    
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }
    
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
    
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }
    
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getPhone() {
		return phone;
	}

	public Date getCreateTime() {
		return createTime;
	}
    
}
