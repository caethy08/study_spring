package pack.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class JikwonDao {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DataMapInterface mapInterface;
	public List<JikwonDto> list(int buser_num, String jikwon_rating){
		List<JikwonDto> list = null;
		try {//등급별 구분
			if(jikwon_rating.equals("all")) {
				list = mapInterface.selectBuser(buser_num);
			} else {				
				list = mapInterface.selectValue(buser_num, jikwon_rating);
			}

		} catch (Exception e) {
			logger.info("list err : " + e);
		}
		
		return list;
	}
}
