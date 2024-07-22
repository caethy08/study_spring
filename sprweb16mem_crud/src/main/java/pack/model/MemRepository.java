package pack.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;


public interface MemRepository extends JpaRepository<Mem, String> {
	//num 자동 증가용 쿼리
	@Query(value = "select max(m.num) from Mem as m")
	//@Query(value = "select max(num) from Mem as mem", nativeQuery = true)
	int findByMaxNum();
	
	@Query("select m from Mem as m where m.num=?1")
	Mem findByNum(String num);
}
