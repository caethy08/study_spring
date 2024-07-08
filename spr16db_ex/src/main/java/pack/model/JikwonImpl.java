package pack.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class JikwonImpl extends JdbcDaoSupport implements JikwonInter {

	@Autowired
	private DataSource dataSource;
	
	@PostConstruct //생성자 다음에 수행되는 메소드
	public void abcd() {
		setDataSource(dataSource);
	}
	
	@Override
	public List<JikwonDto> selectList(String gogek_name) throws DataAccessException {
		RowMapper rowMapper = new JikwonMapper();
		
		String sql = "select jikwon_name, jikwon_jik, jikwon_gen from jikwon inner join gogek on jikwon.jikwon_no=gogek.gogek_damsano";
		/*
		if (gogek_name != null) {
			sql += "where gogek_name=" + gogek_name;
		}else {
			System.out.println("로그인 실패");
		}
		*/
		return getJdbcTemplate().query(sql, rowMapper);
	}
	
	class JikwonMapper implements RowMapper{
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			return new JikwonDto() {
				{
					setJikwon_name(rs.getString("jikwon_name"));
					setJikwon_jik(rs.getString("jikwon_jik"));
					setJikwon_gen(rs.getString("jikwon_gen"));
				}
			};
		}
	}
}
