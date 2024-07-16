package pack.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao extends JdbcDaoSupport {
	// JdbcDaoSupport는 멤버필드로 dataSource, jdbcTemplate <== getter, setter을 가지고 있다.
	@Autowired
	public DataDao(DataSource dataSource) {
		super.setDataSource(dataSource); // 상속을 받고있어서 field injection 불가, construction injection 으로 datadao가 만들어지기 전에 값을
											// 가지고 있어야 한다.
	}

	public List<SangpumDto> getDataAll() {
		String sql = "select * from sangdata";
		return (List) getJdbcTemplate().query(sql, new ItemRowMapper());
	}

	class ItemRowMapper implements RowMapper<Object> {

		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			SangpumDto dto = new SangpumDto();
			dto.setCode(rs.getString("code"));
			dto.setSang(rs.getString("sang"));
			dto.setSu(rs.getString("su"));
			dto.setDan(rs.getString("dan"));

			return dto;
		}
	}

}
