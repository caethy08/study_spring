package pack.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("thymeleaf")
	public String sijak(Model model) {
		//모델과 뷰를 분리
		model.addAttribute("msg", "타임리프 만세!");
		model.addAttribute("msg2", "타임리프 사용중");
		
		// DTO자료 출력용
		Sangpum sangpum = new Sangpum();
		sangpum.setCode("10");
		sangpum.setSang("삼다수3L");
		sangpum.setPrice("3000");
		model.addAttribute("sangpum",sangpum);
		
		ArrayList<Sangpum> list = new ArrayList<Sangpum>();
		list.add(sangpum);
		
		sangpum = new Sangpum();
		sangpum.setCode("20");
		sangpum.setSang("고구마빵");
		sangpum.setPrice("2000");
		list.add(sangpum);
		
		model.addAttribute("list", list);
		
		
		return "list1"; //뷰 list1 forwarding방식으로 templates폴더의 list.html> 그러나 일반적인 html이 아니라 템플릿 엔진임(application.propertise에 지정됨. 그러나 기본값이라 명시x)
	}
}
