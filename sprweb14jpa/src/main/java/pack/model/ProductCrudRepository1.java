package pack.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductCrudRepository1 extends JpaRepository<ProductVo, Integer> {
	//CrudRepository <PagingAndSortingRepostory> JpaRepository
	
	//메소드 이름으로 쿼리 생성 방법: find + (엔티티 이름) + By + 변수 이름
	//엔티티 이름은 생략가능
	ProductVo findByCode(Integer code);
	
	//JPQL
	@Query(value = "select p from ProductVo as p")
	List<ProductVo> findAllData();
	
	//where 조건: 이름기반
	@Query(value = "select p from ProductVo as p where p.code=:code")
	ProductVo findByCodemy(@Param("code") int code);
	//where 조건: 순서기반
	@Query(value = "select p from ProductVo as p where p.code=?1")
	ProductVo findByCodemy2(int code);
	
	@Query(value = "select p from ProductVo as p where p.code=?1 or p.sang=?2")
	List<ProductVo> findByData(int code, String sang);
}
