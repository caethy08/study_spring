package pack.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.model.SangpumDto;

@Repository
public class DataDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	@Autowired
	private DataSource dataSource;
	
	public DataDao() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("driver loading 실패:" + e.getMessage() );
		}
	}
	
	public ArrayList<SangpumDto> selectAll() {
		ArrayList<SangpumDto> list = new ArrayList<SangpumDto>();
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement("select * from sangdata");
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				SangpumDto dto = new SangpumDto();
				dto.setCode(rs.getString("code"));
				dto.setSang(rs.getString("sang"));
				dto.setSu(rs.getString("su"));
				dto.setDan(rs.getString("dan"));
				list.add(dto);
			}
		} catch (Exception e) {
			System.out.println("selectAll err:" + e);
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch (Exception e2) {
				System.out.println("selectAll err:" + e2);
			}
		}
		return list;
	}

}
