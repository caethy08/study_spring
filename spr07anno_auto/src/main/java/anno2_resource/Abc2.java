package anno2_resource;

import org.springframework.stereotype.Component;

@Component("aaa") //객체변수의 이름은 aaa
public class Abc2 {//pojo(순수하게 멤버와 메소드만을 가진 클래스)
	private int nai;
	
	public void setNai(int nai) {
		this.nai = nai;
	}
	
	public int getNai() {
		return nai;
	}
}	
