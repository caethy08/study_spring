package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcessServiceImpl implements ProcessService{
	@Autowired
	private DataDao dataDao; // 클래스의 포함 관계(상속쓰지 않아)
	
	public ProcessServiceImpl() {
		// 내용이 없는 생성자라도 쓰기를 권장함
	}

	
	@Override
	public void selectProcess() {
		System.out.println("selectProcess 처리 시작");
		dataDao.selectData(); // model 영역의 클래스가 수행하고 있는 거임
		System.out.println("selectProcess 처리 끝");
		
		
	}
}
