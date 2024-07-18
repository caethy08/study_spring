package pack.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import pack.controller.MemberBean;

@Repository
public class DataDao extends JdbcDaoSupport {
	@Autowired
	public DataDao(DataSource dataSource) {
		setDataSource(dataSource);
	}
	
	//전체 자료 읽기
	public List<MemberDto> getMemberList(){
		String sql = "select * from memberteb";
		/*
		List<MemberDto> list = getJdbcTemplate().query(sql, new RowMapper() {//내부 무명클래스를 이용해 오버라이딩
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberDto memberDto = new MemberDto();
				memberDto.setId(rs.getString("id"));
				memberDto.setName(rs.getString("name"));
				memberDto.setPasswd(rs.getString("passwd"));
				memberDto.setReg_date(rs.getString("reg_date"));
				return memberDto;
			}
		});
		*/
		//람다 표현식 사용
		List<MemberDto> list = getJdbcTemplate().query(sql, (ResultSet rs, int rowNum) -> {
			MemberDto memberDto = new MemberDto();
			memberDto.setId(rs.getString("id"));
			memberDto.setName(rs.getString("name"));
			memberDto.setPasswd(rs.getString("passwd"));
			memberDto.setReg_date(rs.getString("reg_date"));
			return memberDto;
		});
		return list;
	}
	
	//자료 추가하기
	public void insData(MemberBean bean) {
		String sql = "insert into memberteb values(?,?,?,now())";
		
		Object[] params = {bean.getId(), bean.getName(), bean.getPasswd()}; //bean를 object 객체 배열로 변경해 넣어준다.
		getJdbcTemplate().update(sql, params);
	}
	
	//특정 레코드 읽기
	public MemberDto getMemeber(String id) {
		String sql = "select * from memberteb where id=?";
		
		MemberDto memberdto = (MemberDto)getJdbcTemplate().queryForObject(sql, new Object[] {id}, new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberDto dto = new MemberDto();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setPasswd(rs.getString("passwd"));
				dto.setReg_date(rs.getString("reg_date"));
				return dto;
			}
		});
		return memberdto;
	}
	
	//수정
	public void upDate(MemberBean bean) {
		String sql = "update memberteb set name=?, passwd=? where id=?";
		getJdbcTemplate().update(sql, new Object[] {bean.getName(), bean.getPasswd(), bean.getId()});
	}
	//삭제
	public void delDate(String id) {
		String sql = "delete from memberteb where id=?";
		getJdbcTemplate().update(sql, new Object[] {id});
	}
}
