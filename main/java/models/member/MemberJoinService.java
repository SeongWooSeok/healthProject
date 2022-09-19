package models.member;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.mindrot.bcrypt.BCrypt;

import common.BadRequestException;

public class MemberJoinService extends MemberValidator{
	/**
	 * 회원가입 처리 
	 * 
	 * 1. 필수 데이터 검증
	 * 2. 중복회원 체크
	 * 3. 아이디 체크(알파벳 + 숫자), 비밀번호 복잡성 체크
	 * 3-1. 휴대전화번호 유입시 형식체크, 형식 통일화(숫자로만 구성)
	 * 4. 비밀번호 해시화(bcrypt) 
	 * 5. DB 저장 처리 
	 * @param request
	 */
	public void join(HttpServletRequest request) {
		MemberValidator validator = new MemberValidator();
		
		/** 1. 필수 데이터 검증 S */
		Map<String, String> requiredFields = new HashMap<>();
		requiredFields.put("isAgree", "약관에 동의하세요.");
		requiredFields.put("memId", "아이디를 입력하세요.");
		requiredFields.put("memPw", "비밀번호를 입력하세요.");
		requiredFields.put("memPwRe", "비밀번호를 확인해 주세요.");
		requiredFields.put("memNm", "회원명을 입력하세요.");
		
		validator.requiredCheck(request, requiredFields);
		/** 1. 필수 데이터 검증 E */
		
		String memId = request.getParameter("memId");
		String memPw = request.getParameter("memPw");
		String memPwRe = request.getParameter("memPwRe");
		String memNm = request.getParameter("memNm");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		// 2. 중복회원 체크
		validator.duplicateMember(memId);
		
		// 3. 아이디 체크(알파벳 + 숫자 + 6자리이상), 비밀번호 복잡성 체크
		validator.checkMemId(memId);
		
		validator.checkMemPw(memPw);
		
		if (!memPw.equals(memPwRe)) {
			throw new BadRequestException("비밀번를 다시 확인해 주세요.");
		}
		
		// 3-1 휴대전화번호 형식 통일화, 형식 체크 
		/*if (mobile != null && !mobile.isBlank()) {
			
			mobile = mobile.replaceAll("[^0-9]", "");
			
			if (!validator.checkMobileNum(mobile)) {
				throw new BadRequestException("휴대전화번호 형식이 아닙니다.");
			}
		}*/
		
		// 4. 비밀번호 해시화(bcrypt) 
		String hash = BCrypt.hashpw(memPw, BCrypt.gensalt(12));
		
		 MemberDao dao = MemberDao.getInstance(); 
		 MemberDto param = new MemberDto();
		 param.setMemId(memId);
		 param.setMemNm(memNm);
		 param.setMemPw(hash);
		 param.setEmail(email);
		 param.setMobile(mobile);
		  
		 MemberDto member = dao.register(param);
		 if (member == null) {
			 throw new BadRequestException("회원 가입에 실패하였습니다.");
		 }
	}
}
