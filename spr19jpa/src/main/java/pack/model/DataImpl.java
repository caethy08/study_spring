package pack.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

@Repository
public class DataImpl implements DataInterface {

	@Override
	public List<MemDto> selectDataAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); //persistence.xml의 hello -> 인식함
		EntityManager em = emf.createEntityManager();  //엔티티의 생명주기를 관리. CRUD를 수행
		EntityTransaction tx = em.getTransaction(); //transaction을 관리라는 인터페이스
		
		System.out.println("전체 자료 읽기 ---");
		List<MemDto> list = null;
		list = findAll(em, MemDto.class);
		for (MemDto m: list) {
			System.out.println(m.getNum() + " " + m.getName() + " " + m.getAddr());
		}
		return list;
	}
	
	public<T> List<T> findAll(EntityManager em, Class<T> cla){
		//JPQL 
		return em.createQuery("select e from " + cla.getName() + " e", cla).getResultList();
	}
}
