package pack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pack.entity.Dept;
import pack.entity.Emp;

public interface EmpRepository extends JpaRepository<Emp, Integer>{
	//사원 번호에 대해 오름차순 정렬된 목록 반환 메소드
	public List<Emp> findAllByOrderByEmpnoAsc();
	public List<Emp> findAllByOrderByEmpnoDesc();

	//findAllByOrderByEmpnoAsc() 메소드를 JPQL로 적는다면 아래와 같다
	@Query(value = "select e from Emp e order by e.empno asc")
	public List<Emp> getListAll();
	
	//인자 전달
	//입력 salary 초과 자료 오름차순 정렬
	@Query(value = "select e from Emp as e where e.sal > :salary order by e.sal asc")
	List<Emp> getList(@Param("salary")double salary);
	
	@Query(value = "select e from Emp as e where e.sal > :sal and e.sal < :sal2 order by e.sal asc")
	List<Emp> getListBetween(@Param("sal")int sal, @Param("sal2")int sal2);
	
	@Query(value = "select e from Emp as e where e.sal > ?1 and e.sal < ?2 order by e.sal asc")
	List<Emp> getListBetween2(int sal, int sal2);
}
