package pack.model;

import org.springframework.data.repository.CrudRepository;


public interface ProductCrudRepository extends CrudRepository<ProductVo, Integer> {

	//save(). findbyId(), count(), ... 지원을 받음
	
}
