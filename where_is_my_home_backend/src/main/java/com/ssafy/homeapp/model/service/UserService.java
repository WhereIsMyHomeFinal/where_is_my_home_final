package com.ssafy.homeapp.model.service;

import com.ssafy.homeapp.model.dto.User;

public interface UserService {

	String login(String userid, String password) throws Exception;

	void joinUser(String userid, String password, String name) throws Exception;

	User infoUser(String userid) throws Exception;

	boolean modifyUser(User user) throws Exception;

	boolean withdrawUser(String userid) throws Exception;

	String findpw(String userid, String name) throws Exception;

}