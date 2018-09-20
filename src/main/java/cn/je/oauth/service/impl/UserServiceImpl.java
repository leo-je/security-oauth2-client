package cn.je.oauth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cn.je.oauth.entity.User;
import cn.je.oauth.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		String password = passwordEncoder.encode("123456");//BCrypt.hashpw("123456", BCrypt.gensalt());
		User user = new User(username,password );
		return user;
	}
}
