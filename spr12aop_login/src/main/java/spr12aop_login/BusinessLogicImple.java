package spr12aop_login;

import org.springframework.stereotype.Service;

@Service("bImpl")
public class BusinessLogicImple implements BusinessLogicInter {
	public BusinessLogicImple() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void startProcess() {
		System.out.println("검증이 됐으므로 핵심 로직 수행");
		
	}
}
