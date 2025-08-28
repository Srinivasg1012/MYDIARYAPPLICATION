package com.org.spring.mydiary.Business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.spring.mydiary.dao.UserDaoInterface;
import com.org.spring.mydiary.entities.User;

@Component
public class UserBusinessInterfaceImpl implements UserBusinessInterface {
	
	
	
	@Autowired
	private UserDaoInterface userDaoInterface;
	

	public UserDaoInterface getUserDaoInterface() {
		return userDaoInterface;
	}

	public void setUserDaoInterface(UserDaoInterface userDaoInterface) {
		this.userDaoInterface = userDaoInterface;
	}

	@Override
	public void save(User user) {

		userDaoInterface.save(user);
	}

	@Override
	public void update(User user) {
		userDaoInterface.update(user);
	}

	@Override
	public void delete(User user) {

		userDaoInterface.delete(user);
	}

	@Override
	public User findbyId(int id) {
		return userDaoInterface.findbyId(id);
	}

	@Override
	public List<User> findAll() {
		return userDaoInterface.findAll();
	}

	@Override
	public User findByUsername(String username) {		
		return userDaoInterface.findByUsername(username);
	}

}
