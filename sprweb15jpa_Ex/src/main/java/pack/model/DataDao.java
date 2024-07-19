package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {
	@Autowired
	private JikwonRepository repository;
	
	//직급으로 찾기
	public List<Jikwon> getDataSearch(String svalue){
		List<Jikwon> list = repository.findByjik(svalue);
		return list;
	}
}
