package pack.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import pack.mybatis.SqlMapConfig;

@Repository
public class JickwonImpl implements JickwonInter {
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	@Override
	public List<JickwonDto> selectDataAll() {
		SqlSession sqlSession = factory.openSession();
		List<JickwonDto> list = null;
		
		try {
			SqlMapperInter mapperInter = (SqlMapperInter)sqlSession.getMapper(SqlMapperInter.class);
			list = sqlSession.selectList("selectDataAll");
		} catch (Exception e) {
			System.out.println("selectDataAll err: " + e);
		}finally {
			if(sqlSession != null) sqlSession.close();
		}
		
		return list;
	}
	
	@Override
	public List<JickwonDto> buserNum() {
		SqlSession sqlSession = factory.openSession();
		List<JickwonDto> list = null;
		
		try {
			SqlMapperInter mapperInter = (SqlMapperInter)sqlSession.getMapper(SqlMapperInter.class);
			list = sqlSession.selectList("buserNum");
		} catch (Exception e) {
			System.out.println("buserNum err: " + e);
		}finally {
			if(sqlSession != null) sqlSession.close();
		}
		
		return list;
	}
	
	@Override
	public List<JickwonDto> highPayer() {
		SqlSession sqlSession = factory.openSession();
		List<JickwonDto> list = null;
		
		try {
			SqlMapperInter mapperInter = (SqlMapperInter)sqlSession.getMapper(SqlMapperInter.class);
			list = sqlSession.selectList("highPayer");
		} catch (Exception e) {
			System.out.println("highPayer err: " + e);
		}finally {
			if(sqlSession != null) sqlSession.close();
		}
		
		return list;
	}
}
