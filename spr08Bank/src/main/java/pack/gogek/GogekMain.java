package pack.gogek;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GogekMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("bankinit.xml");

		Gogek daniel = (Gogek)context.getBean("gogek");
		daniel.selectBank("sinhan");
		daniel.playInputMoney(500);
		daniel.playOutputMoney(200);
		System.out.print("daniel - ");
		daniel.showMoney(0);
		
		Gogek john = (Gogek)context.getBean("gogek");
		daniel.selectBank("sinhan");
		daniel.playInputMoney(500);
		daniel.playOutputMoney(200);
		System.out.print("john - ");
		daniel.showMoney(0);
		
		Gogek oscar = (Gogek)context.getBean("gogek");
		daniel.selectBank("hana");
		daniel.playInputMoney(500);
		daniel.playOutputMoney(100);
		System.out.print("oscar - ");
		daniel.showMoney(0);
		
		
		System.out.println("객체 주소 daniel:" + daniel);
		System.out.println("객체 주소 john:" + john);
		System.out.println("객체 주소 oscar:" + oscar);
		//다니엘과 존, 오스카는 같은 객체 취급 >> 싱글톤 패턴을 사용해서 인스턴스가 하나만 생성되었기 때문
	}

}
