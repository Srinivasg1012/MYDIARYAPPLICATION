package com.org.spring.mydiary.dao;

import java.util.List;

import org.springframework.transaction.annotation.*;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.org.spring.mydiary.entities.User;

@Component
public class UserDaoInterfaceImpl implements UserDaoInterface {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	

	public HibernateTemplate getHibernatetemplate() {
		return hibernateTemplate;
	}

	public void setHibernatetemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional(readOnly=false)
	public void save(User user) {
		hibernateTemplate.save(user);
		
		
	}

	@Transactional(readOnly=false)
	public void update(User user) {
		hibernateTemplate.update(user);

		
	}
	@Transactional(readOnly=false)
	public void delete(User user) {
		hibernateTemplate.delete(user);

	}

	public User findbyId(int id) {
		return hibernateTemplate.get(User.class,id);
	}

	public List<User> findAll() {
		return hibernateTemplate.loadAll(User.class);
	}

	@Override
	public User findByUsername(String username) {
		
		DetachedCriteria criteria=DetachedCriteria.forClass(User.class);
		criteria.add(Restrictions.eq("username", username));		
		
		User user=null;
		try
		{
		user=(User)hibernateTemplate.findByCriteria(criteria).get(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return user;
	}

}
