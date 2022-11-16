package com.ssafy.homeapp.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.homeapp.model.dto.User;
import com.ssafy.homeapp.util.DBUtil;

public class UserDAOImpl implements UserDAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private DBUtil dbUtil = DBUtil.getInstance();
	private ResultSet rs = null;
	
	@Override
	public String login(String userid, String password) throws SQLException {
		try {
			conn = dbUtil.getConnection();
			System.out.println(userid + " " + password);
			StringBuilder sql = new StringBuilder();
			sql.append("select name \n");
			sql.append("from userinfo \n");
			sql.append("where userid = ? and password = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, userid);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			String name = null;
			if (rs.next()) {
				name = rs.getString(1);
			}
			System.out.println("name : " + name);
			return name;
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
	}
	
	@Override
	public void joinUser(String userid, String password, String name) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into userinfo(userid, password, name) \n");
			sql.append("values (?, ?, ?)");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, userid);
			pstmt.setString(2, password);
			pstmt.setString(3, name);
			
			int cnt = pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt, conn);
		}
	}
	
	@Override
	public int withdrawUser(String userid) throws SQLException {
		
		String sql = "delete from userinfo where userid = ?";
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			int cnt = pstmt.executeUpdate();
			return cnt;
		} finally {
			dbUtil.close(pstmt, conn);
		}
	}

	@Override
	public User infoUser(String userid) throws SQLException {
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select userid, password, name \n");
			sql.append("from userinfo \n");
			sql.append("where userid = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			User user = null;
			if(rs.next())	user = new User(rs.getString(1), rs.getString(2), rs.getString(3));
			return user;
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
	}

	@Override
	public int modifyUser(User user) throws SQLException {
		try { 
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("update userinfo \n");
			sql.append("set password = ?, name = ? \n");
			sql.append("where userid = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, user.getPassword());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getUserid());
			int cnt = pstmt.executeUpdate();
			return cnt;
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
	}

	@Override
	public String findpw(String userid, String name) throws SQLException {
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select password \n");
			sql.append("from userinfo \n");
			sql.append("where userid = ? and name = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, userid);
			pstmt.setString(2, name);
			String password = null;
			rs = pstmt.executeQuery();
			if(rs.next())	password = rs.getString(1);
			return password;
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
	}
}
