package com.ssafy.homeapp.controller;

//public class HospitalController implements Controller {
//
//	private HospitalService hospitalService = new HospitalService();
//
//	@Override
//	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String url = request.getServletPath();
//		if(url.equals("/hospital/rest/list.do")) {
//			return restGetList(request, response);
//		}
//		return null;
//	}
//
//	private Object restGetList(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String gugunName = request.getParameter("gugunName");
//		List<Hospital> list = hospitalService.restGetList(gugunName);
//		return new DataInfo("application/json", list);
//	}
//}
