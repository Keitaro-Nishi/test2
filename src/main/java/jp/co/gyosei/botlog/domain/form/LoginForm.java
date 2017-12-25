package jp.co.gyosei.botlog.domain.form;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class LoginForm {

	private String custid;
	private String password;
	private Collection<? extends GrantedAuthority> role;
	
	 String getCustid() {
		return custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<? extends GrantedAuthority> getRole() {
		return role;
	}

	public void setRole(Collection<? extends GrantedAuthority> role) {
		this.role = role;
	}

}