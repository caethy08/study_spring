package pack.model;

public class MyInfo implements MyInfoInter {
	//MyInfoInter타입의 파생클래스 중 하나로 MyInfo 작성
	
	@Override
	public String myData() {
		return "취미는 운동(축구)";
	}
}
