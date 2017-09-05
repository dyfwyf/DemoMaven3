package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bean.User;

@Component
public class UserDao {

	@Autowired
	private SessionFactory sf;
	
	public Session getSession(){
		return sf.getCurrentSession();
	}
	
	public void save(User user){
		Session session=this.getSession();
		session.save(user);
	}
	
	public void update(User user){
		Session session=this.getSession();
		session.update(user);
	}
	
	public List<User> listAll(){
		Session session=getSession();
		List<User> list=session.createQuery("from User").list();
		return list;
	}
	
	public void delete(User user){
		Session session=getSession();
		session.delete(user);
	}
	
	public User getById(int id){
		Session session=getSession();
		User user=(User)session.get(User.class, id);
		return user;
	}
}
