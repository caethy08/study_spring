package pack.business;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.model.JikwonDto;
import pack.model.JikwonInter;

@Service
public class BusinessImpl implements BusinessInter {

	@Autowired
	private JikwonInter jikwonInter;
	
	@Override
	public void jikwonList() {
		System.out.println("로그인 정보 입력");
		System.out.print("고객 번호: ");
		Scanner scanner = new Scanner(System.in);
		String gogek_no = scanner.nextLine();
		System.out.println("고객 이름: ");
		Scanner scanner2 = new Scanner(System.in);
		String gogek_name = scanner2.nextLine();
		
		scanner.close();
		
		for(JikwonDto j:jikwonInter.selectList(gogek_name)) {
			System.out.println(j.getJikwon_name() + " " + j.getJikwon_jik() + j.getJikwon_gen());
		}
	}
}
