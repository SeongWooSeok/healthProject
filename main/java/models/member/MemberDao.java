package models.member;

import org.apache.ibatis.session.SqlSession;

import mybatis.Connection;

public class MemberDao {
private static MemberDao instance = new MemberDao();
	
	private MemberDao() {}
	
	/**
	 * 회원 등록 
	 * 
	 * @param member
	 * @return {MemberDto}
	 */
	public MemberDto register(MemberDto member) {
		SqlSession sqlSession = Connection.getSession();
		
		int affectedRows = sqlSession.insert("MemberMapper.register", member);
		
		sqlSession.commit();
		sqlSession.close();
		
		if (affectedRows < 1) 
			return null;
		
		return member;
	}
	
	/**
	 * 회원 조회 
	 * @param memId 아이디 
	 * @return {MemberDto}
	 */
	public MemberDto get(String memId) {
		SqlSession sqlSession = Connection.getSession();
		MemberDto param = new MemberDto();
		param.setMemId(memId);
		
		MemberDto member = sqlSession.selectOne("MemberMapper.member", param);
		
		sqlSession.close();
		
		return member;
	}
	
	public static MemberDao getInstance() {
		if (instance ==null) {
			instance = new MemberDao();
		}
		
		return instance;
	}
}
