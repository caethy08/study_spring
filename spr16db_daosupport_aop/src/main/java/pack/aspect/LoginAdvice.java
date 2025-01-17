package pack.aspect;

import java.util.Scanner;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoginAdvice {
	@Around("execution(public void jikwonList())")
	public Object haha(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.print("로그인 아이디 입력:");
		Scanner scanner = new Scanner(System.in);
		String id = scanner.next();
		
		if(!id.equalsIgnoreCase("kor")) {
			System.out.println("id 불일치. 로그인 실패");
			return null;
		}
		Object object = joinPoint.proceed();
		scanner.close();
		
		return object;
	}
}
