package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface SqlMapperInter {
	@Select("select jikwon_no, jikwon_name, buser_name,  year(jikwon_ibsail) as jikwon_ibsail from jikwon inner join buser on jikwon.buser_num=buser.buser_no")
	public List<JickwonDto> selectDataAll(); //dataMapper불필요
	
	@Select("SELECT buser_name, COUNT(jikwon_no) as jikwon_num FROM jikwon INNER JOIN buser ON jikwon.buser_num = buser.buser_no GROUP BY buser_name")
	public List<JickwonDto> buserNum();
	
	@Select("SELECT buser_name, jikwon_name, jikwon_pay FROM jikwon INNER JOIN buser ON jikwon.buser_num = buser.buser_no WHERE jikwon_pay IN (SELECT MAX(jikwon_pay) FROM jikwon WHERE buser_num = buser_no GROUP BY buser_num) ORDER BY buser_name")
	public List<JickwonDto> highPayer();
	
	//public 생략가능
}
