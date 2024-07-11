package pack;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "test9")
public class TestController2 {

	@RequestMapping(method = RequestMethod.GET)
	public String def1(Model model) {
		//HttpServletRequest 객체에 값을 키밸류 형식으로 저장 후 뷰에 전달
		model.addAttribute("msg", "sucess get");
		return "list"; //forward > 스프링의 기본은 forward
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String def2(Model model) {
		model.addAttribute("msg", "sucess post");
		return "list";
	}
}
