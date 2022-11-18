package models.attendance;

import org.apache.ibatis.session.SqlSession;

import mybatis.Connection;

public class AttendanceDao {
private static AttendanceDao instance = new AttendanceDao();

	private AttendanceDao() {}
	
	public AttendanceDto register(AttendanceDto attendance) {
		SqlSession sqlSession = Connection.getSession();
		
		int affectedRows = sqlSession.insert("Attendance.register", attendance);
		
		sqlSession.commit();
		sqlSession.close();
		
		if (affectedRows < 1) 
			return null;
		
		return attendance;
	}
}
