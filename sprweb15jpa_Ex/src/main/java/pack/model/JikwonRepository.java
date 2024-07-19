package pack.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface JikwonRepository extends JpaRepository<Jikwon, Integer> {

	List<Jikwon> findByjik(String svalue);
	//_못 읽음
	/*
	@Query(value = "select s from Jikwon as s where s.jikwon_jik like %:svalue%")
	List<Jikwon> searchLike(@Param("svalue") String svalue);
	*/
}
