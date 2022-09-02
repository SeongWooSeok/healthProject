package mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Connection {
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		try {
		Reader reader = Resources.getResourceAsReader("mybatis/config/mybatis-config.xml");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static SqlSession getSession() {
		SqlSession session = sqlSessionFactory.openSession();
		
		return session;
	}
}
