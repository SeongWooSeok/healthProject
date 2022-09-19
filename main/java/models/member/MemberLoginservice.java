package models.member;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mindrot.bcrypt.BCrypt;

import common.BadRequestException;

public class MemberLoginservice {
	/**
	 * 로그인 처리 
	 * 1. 필수 항목체크(아이디, 비밀번호)
	 * 2. 등록된 아이디 여부(회원 조회)
	 * 3. 비밀번호 검증 
	 * 4. 회원 정보를 유지(세션)
	 * @param request
	 */
	public void login(HttpServletRequest request) {
		MemberValidator validator = new MemberValidator();
		MemberDao dao = MemberDao.getInstance();
		
		// 1. 필수 항목체크(아이디 - memId, 비밀번호 - memPw)
		Map<String, String> checkFields = new HashMap<>();
		checkFields.put("memId", "아이디를 입력하세요.");
		checkFields.put("memPw", "비밀번호를 입력하세요.");
		validator.requiredCheck(request, checkFields);
		
		String memId = request.getParameter("memId");
		String memPw = request.getParameter("memPw");
		
		// 2. 등록된 아이디 여부(회원 조회)
		MemberDto member = dao.get(memId);
		if (member == null) {
			throw new BadRequestException("등록된 회원 아이디가 아닙니다 - " + memId);
		}
		
		// 3. 비밀번호 검증
		boolean isMatched = BCrypt.checkpw(memPw, member.getMemPw());
		if (!isMatched) {
			throw new BadRequestException("비밀번호가 일치하지 않습니다.");
		}
		
		// 4. 회원 정보를 유지(세션)
		HttpSession session = request.getSession();
		
		member.setMemPw(null);
		session.setAttribute("member", member);
	}
}
