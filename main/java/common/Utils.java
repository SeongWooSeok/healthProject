package common;

import java.io.File;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.member.MemberDto;

public class Utils {
	/**
	 * 예외를 alert 출력 
	 * @param response
	 * @param e
	 */
	public static void alertError(HttpServletResponse response, RuntimeException e) {
		try {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('" + e.getMessage() + "');</script>");
		} catch (Exception _e) {}
	}
	
	/**
	 * 페이지 이동
	 * @param response
	 * @param url
	 * @param target - _self, parent, ... 
	 */
	public static void go(HttpServletResponse response, String url, String target) {
		response.setContentType("text/html; charset=utf-8");
		try {
			PrintWriter out = response.getWriter();
			out.printf("<script>%s.location.replace('%s');</script>", target, url);
		} catch (Exception e) {}
	}
	
	public static void go(HttpServletResponse response, String url) {
		go(response, url, "_self");
	}
	
	/**
	 * 메세지 출력(alert)
	 * 
	 * @param response
	 * @param message
	 * @param addScript -  메세지 출력 후 실행될 자바스크립트
	 */
	public static void alert(HttpServletResponse response, String message, String addScript) {
		response.setContentType("text/html; charset=utf-8");
		try {
			PrintWriter out = response.getWriter();
			if (addScript == null) addScript = "";
			out.printf("<script>alert('%s');%s</script>", message, addScript);
		} catch (Exception e) {}
	}
	
	public static void alert(HttpServletResponse response, String message) {
		alert(response, message, null);
	}
	
	/**
	 * 로그인한 회원 정보
	 * 
	 * @param request
	 * @return
	 */
	public static MemberDto getMember(HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberDto member = (MemberDto)session.getAttribute("member");
		
		return member;
	}
	
	
	/**
	 * 로그인 여부
	 * 
	 * @param request
	 * @return
	 */
	public static boolean isLogin(HttpServletRequest request) {
		HttpSession session = request.getSession();
		return session.getAttribute("member") != null;
	}
	
}