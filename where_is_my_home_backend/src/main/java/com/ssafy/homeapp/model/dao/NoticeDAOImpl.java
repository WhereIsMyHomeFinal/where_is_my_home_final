package com.ssafy.homeapp.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.homeapp.model.dto.Notice;
import com.ssafy.homeapp.util.DBUtil;

//public class NoticeDAOImpl implements NoticeDAO {
//
//	private Connection conn;
//	private PreparedStatement pstmt;
//	private ResultSet rs;
//	private DBUtil dbUtil = DBUtil.getInstance();
//	
//	@Override
//	public List<Notice> getNotices() throws SQLException {
//		try {
//			List<Notice> noticeList = new ArrayList<>();
//			conn = dbUtil.getConnection();
//			StringBuilder sql = new StringBuilder();
//			sql.append("select id, title, userid, content \n");
//			sql.append("from notice ");
//			pstmt = conn.prepareStatement(sql.toString());
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				noticeList.add(new Notice(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
//			}
//			return noticeList;
//		} finally {
//			dbUtil.close(rs, pstmt, conn);
//		}
//	}
//	
//	@Override
//	public Notice getNotice(int id) throws SQLException {
//		try {
//			conn = dbUtil.getConnection();
//			StringBuilder sql = new StringBuilder();
//			sql.append("select id, title, userid, content \n");
//			sql.append("from notice \n");
//			sql.append("where id = ? ");
//			pstmt = conn.prepareStatement(sql.toString());
//			pstmt.setInt(1, id);
//			rs = pstmt.executeQuery();
//			Notice notice = null;
//			if (rs.next()) {
//				notice = new Notice(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
//			}
//			return notice;
//		} finally {
//			dbUtil.close(rs, pstmt, conn);
//		}
//	}
//	
//	@Override
//	public int registerNotice(Notice notice) throws SQLException {
//		try {
//			conn = dbUtil.getConnection();
//			StringBuilder sql = new StringBuilder();
//			sql.append("insert into notice (title, userid, content) \n");
//			sql.append("values (?, ?, ?) ");
//			pstmt = conn.prepareStatement(sql.toString());
//			pstmt.setString(1, notice.getTitle());
//			pstmt.setString(2, notice.getUserid());
//			pstmt.setString(3, notice.getContent());
//			int cnt = pstmt.executeUpdate();
//			System.out.println("title : " + notice.getTitle() + ", userid : " + notice.getUserid() + ", content : " + notice.getContent() + ", rowCnt : " + cnt);
//			return cnt;
//		} finally {
//			dbUtil.close(rs, pstmt, conn);
//		}
//	}
//	
//	@Override
//	public int modifyNotice(Notice notice) throws SQLException {
//		try {
//			conn = dbUtil.getConnection();
//			StringBuilder sql = new StringBuilder();
//			sql.append("update notice \n");
//			sql.append("set title = ?, content = ? \n");
//			sql.append("where id = ?");
//			pstmt = conn.prepareStatement(sql.toString());
//			pstmt.setString(1, notice.getTitle());
//			pstmt.setString(2, notice.getContent());
//			pstmt.setInt(3, notice.getId());
//			int cnt = pstmt.executeUpdate();
//			return cnt;
//		} finally {
//			dbUtil.close(rs, pstmt, conn);
//		}
//	}
//	
//	@Override
//	public int deleteNotice(int id) throws SQLException {
//		try {
//			conn = dbUtil.getConnection();
//			StringBuilder sql = new StringBuilder();
//			sql.append("delete from notice \n");
//			sql.append("where id = ? ");
//			pstmt = conn.prepareStatement(sql.toString());
//			pstmt.setInt(1, id);
//			int cnt = pstmt.executeUpdate();
//			return cnt;
//		} finally {
//			dbUtil.close(rs, pstmt, conn);
//		}
//	}
//}
