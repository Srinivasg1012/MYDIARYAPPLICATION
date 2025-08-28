package com.org.spring.mydiary.Business;

import java.util.List;

import com.org.spring.mydiary.entities.User;

public interface UserBusinessInterface {

	public void save(User user);
	public void update(User user);
	public void delete(User user);
	public User findbyId(int id);
	public List<User> findAll();
	public User findByUsername(String username);


}
