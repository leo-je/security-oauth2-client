package cn.je.oauth.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class User implements UserDetails {

	private static final long serialVersionUID = 1L;

	private String username;
	private String password;

	public User(String username, String password) {
		this.password = password;
		this.username = username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public String getPassword() {
		// TODO 自动生成的方法存根
		return this.password;
	}

	@Override
	public String getUsername() {
		// TODO 自动生成的方法存根
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO 自动生成的方法存根
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO 自动生成的方法存根
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO 自动生成的方法存根
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO 自动生成的方法存根
		return true;
	}

}
