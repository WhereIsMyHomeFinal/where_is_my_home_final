package com.ssafy.homeapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CoronaController {

//	private CoronaService coronaService = new CoronaService();
//	
//	@Override
//	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String url = request.getServletPath();
//		if(url.equals("/corona/rest/list.do")) {
//			return restgetList(request, response);
//		}
//		return null;
//	}
//
//	private Object restgetList(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String gugunName = request.getParameter("gugunName");
//		System.out.println(gugunName);
//		List<Corona> list = coronaService.getList(gugunName);
//		return new DataInfo("application/json", list);
//	}
}
