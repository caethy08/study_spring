package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessImpl implements BusinessInter{
	// db처리를 하는 model class를 포함관게로 호출
	
	@Autowired
	private SangpumInter sangpumInter;
	
//	public void setSangpumInter(SangpumInter sangpumInter) {
//		this.sangpumInter = sangpumInter;
//	}
	
	/*
	@Override
	public void selectProcess() {
		for(SangpumDto s:sangpumInter.selectAll()) {
			System.out.println(s.getCode() + " " + s.getSang() + " " + s.getSu() + " " + s.getDan());
		}
		
	}
	*/
	@Override
	public void selectProcess() {
		// 람다 표현식
		sangpumInter.selectAll().forEach(s -> 
		System.out.println(s.getCode() + " " + s.getSang() + " " + s.getSu() + " " + s.getDan()));
		
	}
}
