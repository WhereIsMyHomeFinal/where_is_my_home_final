package com.ssafy.homeapp.controller;

public class UserController {
	
//	private UserService userService = new UserService();
//	
//	@Override
//	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String url = request.getServletPath();
//		if(url.equals("/user/login.do")) {
//			return login(request, response);
//		} else if(url.equals("/user/logout.do")) {
//			return logout(request, response);
//		} else if(url.equals("/user/login_form.do")) {
//			return loginForm(request, response);
//		} else if(url.equals("/user/join_form.do")) {
//			return joinForm(request, response);
//		} else if(url.equals("/user/join.do")) {
//			return join(request, response);
//		} else if(url.equals("/user/withdraw.do")) {
//			return withdraw(request, response);
//		} else if(url.equals("/user/info.do")) {
//			return info(request, response);
//		} else if(url.equals("/user/modify.do")) {
//			return modify(request, response);
//		} else if(url.equals("/user/find_pw.do")) {
//			return findpw(request, response);
//		}
//		return null;
//	}
//
//	private Object findpw(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String userid = request.getParameter("userid");
//		String name = request.getParameter("name");
//		String password = userService.findpw(userid, name);
//		
//		if(password == null)	request.setAttribute("msg", "회원 가입 정보가 없습니다!");
//		else	request.setAttribute("msg", userid + "님의 비밀번호는 " + password + "입니다!");
//		return new PageInfo(true, "/index.do");
//	}
//
//	private Object info(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		HttpSession session = request.getSession();
//		String userid = (String)session.getAttribute("userid");
//		User user = userService.infoUser(userid);
//		request.setAttribute("user", user);
//		return new PageInfo(true, "/user/info.jsp");
//	}
//
//	private Object modify(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String userid = request.getParameter("userid");
//		String password = request.getParameter("password");
//		String name = request.getParameter("name");
//		
//		boolean res = userService.modifyUser(new User(userid, password, name));
//		if(res)	request.setAttribute("msg", "정보 수정에 성공하였습니다.");
//		else	request.setAttribute("msg", "정보 수정에 실패하였습니다.");
//		return new PageInfo(true, "/index.do");
//	}
//
//	private Object logout(HttpServletRequest request, HttpServletResponse response) {
//		HttpSession session = request.getSession();
//		session.invalidate();
//		return new PageInfo(false, "/index.do");
//	}
//
//	private Object login(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String userid = request.getParameter("userid");
//		String password = request.getParameter("password");
//		String name = userService.login(userid, password);
//		System.out.println(name);
//		if(name != null) {
//			HttpSession session = request.getSession();
//			session.setAttribute("userid", userid);
//			session.setAttribute("userName", name);
//			return new PageInfo(false, "/index.do");
//		} else {
//			request.setAttribute("errorMsg", "로그인에 실패하였습니다.");
//			return new PageInfo(true, "/user/login.jsp");
//		}
//	}
//
//	private Object join(HttpServletRequest request, HttpServletResponse response) {
//		String userid = request.getParameter("userid");
//		String password = request.getParameter("password");
//		String name = request.getParameter("name");
//		try {
//			userService.joinUser(userid, password, name);
//			return new PageInfo(true, "/index.jsp");
//		} catch (Exception e) {
//			e.printStackTrace();
//			request.setAttribute("msg", "회원 가입 처리중 에러가 발생했습니다.");
//			return new PageInfo(true, "/error/error.jsp");
//		}
//	}
//	
//	private Object withdraw(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String userid = request.getParameter("userid");
//		boolean res = userService.withdrawUser(userid);
//		if(res)	request.setAttribute("msg", "정보 삭제에 성공하였습니다.");
//		else	request.setAttribute("msg", "정보 삭제에 실패하였습니다.");
//		return new PageInfo(true, "/user/logout.do");
//	}
//
//	private Object joinForm(HttpServletRequest request, HttpServletResponse response) {
//		return new PageInfo(true, "/user/join.jsp");
//	}
//	
//	private Object loginForm(HttpServletRequest request, HttpServletResponse response) {
//		return new PageInfo(true, "/user/login.jsp");
//	}
}
