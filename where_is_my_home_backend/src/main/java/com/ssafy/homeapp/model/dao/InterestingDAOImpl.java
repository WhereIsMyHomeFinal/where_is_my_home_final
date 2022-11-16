package com.ssafy.homeapp.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.homeapp.model.dto.CommercialArea;
import com.ssafy.homeapp.model.dto.InterestingPlace;
import com.ssafy.homeapp.util.DBUtil;

//@Repository
//public class InterestingDAOImpl implements InterestingDAO {
//	
//	private Connection conn = null;
//	private PreparedStatement pstmt = null;
//	private ResultSet rs = null;
//	private DBUtil dbUtil = DBUtil.getInstance();
//
//	@Override
//	public List<InterestingPlace> getPlaces(String userid) throws SQLException {
//		List<InterestingPlace> list = new ArrayList<>();
//		try {
//			conn = dbUtil.getConnection();
//			StringBuilder sql = new StringBuilder();
//			sql.append("select i.userid, i.dongName, s.sidoName, g.gugunName, i.lat, i.lng \n");
//			sql.append("from interestingplaces i, guguncode g, sidocode s \n");
//			sql.append("where userid = ? and i.gugunName = g.gugunName and i.sidoName = s.sidoName ");
//			pstmt = conn.prepareStatement(sql.toString());
//			pstmt.setString(1, userid);
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				list.add(new InterestingPlace(rs.getString(1), rs.getString(2), rs.getString(3), 
//						rs.getString(4), rs.getString(5), rs.getString(6)));
//			}
//			return list;
//		} finally {
//			dbUtil.close(rs, pstmt, conn);
//		}
//	}
//
//	@Override
//	public InterestingPlace getPlace(String userid, String dongName) throws SQLException {
//		InterestingPlace interestingPlace = null;
//		try {
//			conn = dbUtil.getConnection();
//			StringBuilder sql = new StringBuilder();
//			sql.append("select userid, dongName, sidoName, gugunName, lat, lng \n");
//			sql.append("from interestingplaces \n");
//			sql.append("where dongName = ? and userid = ? ");
//			
//			pstmt = conn.prepareStatement(sql.toString());
//			pstmt.setString(1, dongName);
//			pstmt.setString(2, userid);
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				interestingPlace = new InterestingPlace(rs.getString(1), rs.getString(2), rs.getString(3), 
//						rs.getString(4), rs.getString(5), rs.getString(6));
//			}
//			return interestingPlace;
//		} finally {
//			dbUtil.close(rs, pstmt, conn);
//		}
//	}
//
//	@Override
//	public int registerPlace(InterestingPlace interestingPlace) throws SQLException {
//		try {
//			String dongName = interestingPlace.getDongName();
//			String sidoName = interestingPlace.getSidoName();
//			String gugunName = interestingPlace.getGugunName();
//			
//			conn = dbUtil.getConnection();
//			StringBuilder sql = new StringBuilder();
//			sql.append("insert into interestingplaces \n");
//			sql.append("values(?, ?, ?, ?, (select lat from baseaddress where dongName = ? \n)");
//			sql.append(", (select lng from baseaddress where dongName = ?))");
//			
//			pstmt = conn.prepareStatement(sql.toString());
//			pstmt.setString(1, interestingPlace.getUserid());
//			pstmt.setString(2, dongName);
//			pstmt.setString(3, sidoName);
//			pstmt.setString(4, gugunName);
//			pstmt.setString(5, dongName);
//			pstmt.setString(6, dongName);
//			int cnt = pstmt.executeUpdate();
//			return cnt;
//		} finally {
//			dbUtil.close(pstmt, conn);
//		}
//	}
//
//	@Override
//	public int deletePlace(String userid, String dongName) throws SQLException {
//		try {
//			conn = dbUtil.getConnection();
//			StringBuilder sql = new StringBuilder();
//			sql.append("delete from interestingplaces \n");
//			sql.append("where userid=? and dongName=?");
//			
//			pstmt = conn.prepareStatement(sql.toString());
//			pstmt.setString(1, userid);
//			pstmt.setString(2, dongName);
//			int cnt = pstmt.executeUpdate();
//			return cnt;
//		} finally {
//			dbUtil.close(pstmt, conn);
//		}
//	}
//
//	@Override
//	public List<CommercialArea> getCommercialAreas(String dongName) throws SQLException {
//		try {
//			List<CommercialArea> commercialAreaList = new ArrayList<>();
//			conn = dbUtil.getConnection();
//			StringBuilder sql = new StringBuilder();
//			sql.append("select name, lat, lng \n");
//			sql.append("from commercialareainfo \n");
//			sql.append("where dongName=? \n");
//			sql.append("limit 20");
//			pstmt = conn.prepareStatement(sql.toString());
//			pstmt.setString(1, dongName);
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				commercialAreaList.add(new CommercialArea(rs.getString(1), rs.getString(2), rs.getString(3)));
//			}
//			return commercialAreaList;
//		} finally {
//			dbUtil.close(rs, pstmt, conn);
//		}
//	}
//}
