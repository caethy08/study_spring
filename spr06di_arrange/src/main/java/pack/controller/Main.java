package pack.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		/*
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:arrange.xml"); //클래스패스는 리소스에 넣어놨기 떄문에 생략 가능
		*/
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:arrange.xml");
		
		System.out.println("Singleton 확인하세요");
		MessageImpl impl1 = (MessageImpl)context.getBean("mImpl"); //arrange.xml에서 받어옴
		impl1.sayHi();
		MessageImpl impl2 = (MessageImpl)context.getBean("mImpl");
		impl2.sayHi();
		System.out.println("객체 주소 : " + impl1 + " " + impl2);
		
		System.out.println("--다형성 처리하세요");
		MessageInter inter = (MessageInter)context.getBean("mImpl");
		inter.sayHi();
		
		System.out.println("\n---다형성 처리하세요2");
		MessageInter inter2 = context.getBean("mImpl", MessageInter.class);
		inter2.sayHi();
		
		context.close();
	}

}
