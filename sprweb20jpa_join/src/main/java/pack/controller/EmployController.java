package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import pack.dto.DeptDto;
import pack.dto.EmpListDto;
import pack.entity.Dept;
import pack.entity.Emp;
import pack.repository.DeptRepository;
import pack.repository.EmpRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class EmployController {
	@Autowired
	private EntityManagerFactory factory;
	
	@Autowired
	private EmpRepository empRepository;
	
	@Autowired
	private DeptRepository deptRepository;
	
	@GetMapping("/employ/elist")
	public String emplist(Model model) {
		//모든 직원 정보 출력
		//List<Emp> list = empRepository.findAll(); //기본 메소드
		//List<Emp> list = empRepository.findAllByOrderByEmpnoAsc();
		//List<Emp> list = empRepository.findAllByOrderByEmpnoDesc();
		List<Emp> list = empRepository.getListAll(); //jpql
		//List<Emp> list = empRepository.getList(1500);
		
		model.addAttribute("list", list);
		return "employ/elist";
	}
	
	@GetMapping("/employ/dept")
	public String emplist(@RequestParam("deptno") int deptno, Model model) {
		Dept d = deptRepository.findById(deptno).get();
		DeptDto dto = DeptDto.toDto(d);
		model.addAttribute("dto", dto);
		return "employ/dept";
	}
	
	//JPQL 연습장 관련
	@GetMapping("/jpql")
	public String jpql1() {
		return "jpql";
	}
	
	@ResponseBody //json으로 찍기 위해서 
	@PostMapping("/jpql/test")
	public List<EmpListDto> test(@RequestParam("query") String query) {
		//System.out.println(query);
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		List<EmpListDto> list = null;
		try {
			//전달받은 query(jpql)문을 실행
			TypedQuery<Emp> tQuery = em.createQuery(query, Emp.class);
			
			list = tQuery.getResultStream().map(EmpListDto::toDto).toList();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			em.close();
		}
		return list;
	}
	
	
}
