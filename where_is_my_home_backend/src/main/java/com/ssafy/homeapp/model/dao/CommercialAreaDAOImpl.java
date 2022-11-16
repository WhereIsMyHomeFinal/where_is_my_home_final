package com.ssafy.homeapp.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.homeapp.model.dto.CommercialArea;
import com.ssafy.homeapp.util.DBUtil;

public class CommercialAreaDAOImpl {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DBUtil dbUtil = DBUtil.getInstance();
	
	public List<CommercialArea> getCommercialAreas(String dongName) throws SQLException {
		try {
			List<CommercialArea> commercialAreaList = new ArrayList<>();
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select name, lat, lng \n");
			sql.append("from commercialareainfo \n");
			sql.append("where dongName=? \n");
			sql.append("limit 20");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, dongName);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				commercialAreaList.add(new CommercialArea(rs.getString(1), rs.getString(2), rs.getString(3)));
			}
			return commercialAreaList;
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
	}
}
