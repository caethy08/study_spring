package anno1_auto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component  //Single pattern으로 Sender 객체 생성. 객체 변수명은 sender 단순하게 객체만 만들고 싶다면  component
@Component("sender")
@Scope("singleton") //7, 8 두줄을 축약한 게 6행 기본이름이 아닌 자기가 정하고 싶다면 @Component("sen")처럼 따로써줘야 함

public class Sender implements SenderInter { //추상 메소드 오버라이딩
	public void show() {
		System.out.println("Sender의 show method 수행");
	}
}
