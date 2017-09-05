package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bean.User;
import com.dao.UserDao;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public void save(User user){
		this.userDao.save(user);
	}
	
	public void update(User user){
		this.userDao.update(user);
	}
	
	public User getById(int id){
		return this.userDao.getById(id);
	}
	
	public List<User> listAll(){
		return this.userDao.listAll();
	}
	
	public void delete(User user){
		
		this.userDao.delete(user);
	}
}
