package com.ssafy.homeapp.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.homeapp.model.dto.Corona;
import com.ssafy.homeapp.util.DBUtil;

public class CoronaDAOImpl {

	private DBUtil dbUtil = DBUtil.getInstance();
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public List<Corona> getList(String gugunName) throws SQLException {
		List<Corona> coronaList = new ArrayList<>();
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select sidoName, gugunName, name, address, telno \n");
			sql.append("from corona \n");
			sql.append("where gugunName = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, gugunName);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				coronaList.add(new Corona(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
			return coronaList;
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
	}
}
