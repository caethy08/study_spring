package pack.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class JikDao extends JdbcDaoSupport {
	@Autowired
	public JikDao(DataSource dataSource) {
		setDataSource(dataSource);
	}
	public List<JikDto> getJikList(String jikwon_jik){
		String sql = "select * from jikwon where jikwon_jik=?";
		/*
		List<JikDto> list = getJdbcTemplate().query(sql, new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				JikDto dto = new JikDto();
				dto.setJikwon_no(rs.getString("jikwon_no"));
				dto.setJikwon_name(rs.getString("jikwon_name"));
				dto.setJikwon_gen(rs.getString("jikwon_gen"));
				dto.setJikwon_pay(rs.getString("jikwon_pay"));		
				return dto;
			}
		});
		*/
	List<JikDto> list = getJdbcTemplate().query(sql, (ResultSet rs, int rowNum) -> {
		JikDto dto = new JikDto();
		dto.setJikwon_no(rs.getString("jikwon_no"));
		dto.setJikwon_name(rs.getString("jikwon_name"));
		dto.setJikwon_gen(rs.getString("jikwon_gen"));
		dto.setJikwon_pay(rs.getString("jikwon_pay"));
		return dto;
	});
	return list;
			
	}
}
