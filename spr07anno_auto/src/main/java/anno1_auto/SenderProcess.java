package anno1_auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//참고 : 계층(Layers)별 어노테이션 구분
//Application layer : 클라이언트와 데이터 입출력을 제어 @Controller..
//Domain layer : 어플리케이션 중심이며, 업무처리를 담당 @Service ...
//Infrastructor layer: DB에 대한 영속성(persistence) 등을 담당 @Repository ...

//@Component
@Service  //서비스를 위한 클래스 @Service("senderProcess") & @Scope("singleton")
public class SenderProcess {
	//@ Autowired : Bean의 자동 삽입을 위해 사용하는 어노테이션. (name이 아닌 type 으로 매핑)
	@Autowired  //field injection: 간단하나 test가 불편. 주로 사용
	private Sender sender;  
	
	
    /*	
	@Autowired  //setter injection : 코드가 장황해짐
	public void setSender(Sender sender) {
		this.sender = sender;
	}
	
	@Autowired //constructor injection : 불변성과 테스트가 편하지만 생성자가 너무 많아짐
	public SenderProcess(Sender sender) {
		this.sender = sender;
	}
	*/
	
	public Sender getSender() {
		return sender;
	}
	public void dispDate() {
		sender.show();
	}
}
