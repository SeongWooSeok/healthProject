package models.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.Connection;

public class MemberTest {
	public static void main(String[] args) {
		SqlSession sqlSession = Connection.getSession();

		MemberDto member = new MemberDto();
		member.setMemId("user4");
		member.setMemPw("123456");
		member.setMemNm("사용자1(t수정)");
		member.setEmail("user1@test.org");
		member.setMobile("01010001000");
		
		int affectedRows = sqlSession.insert("MemberMapper.delete", member);
		System.out.println("반영된 레코드 수 : " + affectedRows);
		System.out.println(member);

		sqlSession.commit();
		sqlSession.close();
	}

}
