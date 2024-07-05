package anno3_etc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("my") //객체변수의 이름은 my
public class MyProcess {
	//@Value변수에 값을 초기화하기 위해 사용할 수도 있다.
	//@Value("#{dataInfo.name}") => Spring EL : #{표현식}, 만들어진 Component 객체를 이용,private는 getter를 이용해서 가져옴
//	SpEL 표현식은 # 기호로 시작하며 중괄호로 묶어서 표현한다. #{표현식}
//	속성 값을 참조할 때는 $ 기호와 중괄호로 묶어서 표현한다. ${property.name}
	@Value("#{dataInfo.name}")
	private String name;
	private String part;
	
	@Autowired
	//public MyProcess(@Value("영업부") String part) {
	public MyProcess(@Value("#{dataInfo.part}") String part) { //생성자를 통해 값을 밀어넣음
		this.part = part;
	}
	
	@Value("123") //value에서 값을 줄때는 ㄱ본적으로 string type
	private int age;
	
	@Value("1,2,3,4")
	private int arr[];
	
	public void showData() {
		System.out.println("name: " + name);
		System.out.println("part: " + part);
		System.out.println("age: " + age);
		System.out.println(arr[0] + " " + arr[3]);
	}
}
