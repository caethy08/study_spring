package anno1_auto;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configuration //환경 설정, xml의 필요가 없어짐
@ComponentScan(basePackages = "anno1_auto") //스캔을 여기서 끝냄
public class Main1 {
	public static void main(String[] args) {
		//@Autowired에 대한 메인, xml대신 클래스로 환경을 설정. 타입에 대한 매핑
		//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main1.class);
				
		//xml을 계속해서 사용하고 싶을 경우
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:anno1.xml");
		
		SenderProcess process = context.getBean("senderProcess", SenderProcess.class);
		process.dispDate();
	}
}
