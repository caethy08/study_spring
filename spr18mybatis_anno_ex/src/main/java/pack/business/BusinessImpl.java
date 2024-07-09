package pack.business;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.model.JickwonDto;
import pack.model.JickwonInter;

@Service
public class BusinessImpl implements BusinessInter{
	
	@Autowired
	private JickwonInter inter;
	
	@Override
	public void jikwonPrint() {
		List<JickwonDto> list = inter.selectDataAll();
		
		System.out.println("직원자료");
		System.out.println("사번" + " " + "이름" + "  " + "부서명" + " " + "입사년");
		for (JickwonDto j:list) {
			System.out.println(j.getJikwon_no() + " " + j.getJikwon_name() + " " + j.getBuser_name() + " " + j.getJikwon_ibsail());
		}
		
	}
	@Override
	public void buserNum() {
		List<JickwonDto> list = inter.buserNum();
		
		System.out.println("부서별 인원수");
		for (JickwonDto j:list) {
			System.out.println(j.getBuser_name() + " " + j.getJikwon_num() + "명");
		}
		
	}
	@Override
	public void highPayer() {
		List<JickwonDto> list = inter.highPayer();
		
		System.out.println("부서별 최대 급여자");
		for (JickwonDto j: list) {
			System.out.println(j.getBuser_name() + " : " + j.getJikwon_name() + "(" + j.getJikwon_pay() + ")");
		}
		
	}
}
