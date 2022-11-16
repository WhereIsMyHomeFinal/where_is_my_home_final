package com.ssafy.homeapp.model.service;

import com.ssafy.homeapp.model.dao.UserDAO;
import com.ssafy.homeapp.model.dao.UserDAOImpl;
import com.ssafy.homeapp.model.dto.User;

public class UserServiceImpl implements UserService {

	private UserDAO userDAO = new UserDAOImpl();
	
	@Override
	public String login(String userid, String password) throws Exception {
		return userDAO.login(userid, password);
	}

	@Override
	public void joinUser(String userid, String password, String name) throws Exception {
		userDAO.joinUser(userid, password, name);
	}

	@Override
	public User infoUser(String userid) throws Exception {
		return userDAO.infoUser(userid);
	}

	@Override
	public boolean modifyUser(User user) throws Exception {
		return userDAO.modifyUser(user) > 0;
	}

	@Override
	public boolean withdrawUser(String userid) throws Exception {
		return userDAO.withdrawUser(userid) > 0;
	}

	@Override
	public String findpw(String userid, String name) throws Exception {
		return userDAO.findpw(userid, name);
	}
}
