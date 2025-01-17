package pack;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import other.OtherClass;
import pack.model.ProductCrudRepository;
import pack.model.ProductVo;

@SpringBootApplication
@ComponentScan(basePackages = {"other"})
public class Sprweb13jpaBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sprweb13jpaBasicApplication.class, args).getBean(Sprweb13jpaBasicApplication.class).myExecute();
	}
	
	@Autowired
	ProductCrudRepository crudRepository;
	@Autowired
	OtherClass class1;
	
	private void myExecute() {
		System.out.println("독립적인 프로그램으로 실행");
		
		insData();
		selectData();
		delData();
	}
	
	private void insData() {
//		ProductVo productVo = new ProductVo();
//		productVo.setCode(4);
//		...
		//ProductVo productVo = new ProductVo(null, "볼펜", 2, 1000);
		ProductVo productVo = new ProductVo(2, "사랑비", 10, 1000);
		//System.out.println(productVo.toString());
		crudRepository.save(productVo); //번호를 줬는데 없으면  insert, 있으면 update
	}
	
	private void delData() {
		crudRepository.deleteById(3);
	}
	
	private void selectData() {
		//전체 레코드 읽기
		List<ProductVo> list = (List<ProductVo>)crudRepository.findAll(); //내부적으로 select * from product가 실행됨
		//System.out.println(list.get(0).getSang());
		for (ProductVo p : list) {
			System.out.println(p.getCode() + " " + p.getSang() + " " + p.getSu() + " " + p.getDan());
		}
		
		//1개 레코드 읽기
		ProductVo vo = crudRepository.findById(2).get();
		System.out.println(vo.getCode() + " " + vo.getSang() + " " + vo.getSu() + " " + vo.getDan());
	}

}
