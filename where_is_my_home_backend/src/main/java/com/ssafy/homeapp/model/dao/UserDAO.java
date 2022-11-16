package com.ssafy.homeapp.model.dao;

import java.sql.SQLException;

import com.ssafy.homeapp.model.dto.User;

public interface UserDAO {

	String login(String userid, String password) throws SQLException;

	void joinUser(String userid, String password, String name) throws SQLException;

	int withdrawUser(String userid) throws SQLException;

	User infoUser(String userid) throws SQLException;

	int modifyUser(User user) throws SQLException;

	String findpw(String userid, String name) throws SQLException;

}