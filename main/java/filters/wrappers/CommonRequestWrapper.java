package filters.wrappers;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class CommonRequestWrapper extends HttpServletRequestWrapper {

	public CommonRequestWrapper(HttpServletRequest request) throws UnsupportedEncodingException {
		super(request);
		
		/** 
		 * 요청 메서드 POST일때   
		 * 1. charset을 UTF-8로 고정  
		 * 2. RequestURL을 공통값으로 설정
		 */
		String method = request.getMethod().toUpperCase();
		if (method.equals("POST")) {
			request.setCharacterEncoding("UTF-8");
		}
		
		String requestURL = request.getRequestURL().toString();
		request.setAttribute("requestURL", requestURL);
	}
}