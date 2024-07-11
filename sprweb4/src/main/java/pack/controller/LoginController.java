package pack.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class LoginController {
	//로그 정보 출력용 클래스
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@GetMapping("login")
	public String subMitCall() { //model.addattribute는 사용 불가능 > 서버사이드가 아닌 클라이언트 사이드인 html임 
		//webapp이 context root
		//return "redirect:login.html"; //forward : 기본 값
		return "redirect:login.html";  //redirect방식을 사용하기 위해서는 명시적으로 적어줘야함
		//return "redirect:http://localhost/login.html";
	}
	
	/*
	//클라이언트가 전달한 값 수신 방법1: 전통적인 방법
	@PostMapping("login")
	public String submit(HttpServletRequest request, Model model) { //클라이언트 요청을 받아오기 때문에 request
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		System.out.println(id + " " + pwd);
		logger.info(id + " " + pwd); //로그레벨 trace > debug > info > warn > error > fatal
		
		String data = "";
		if(id.equals("kor") && pwd.equals("111"))
			data = "로그인 성공";
		else 
			data = "로그인 실패";
		
		model.addAttribute("data", data);
		
		return "result";
	}
	*/
	
	//클라이언트가 전달한 값 수신 방법 2 : Spring 어노테이션 사용
	@PostMapping("login")
	public String submit(@RequestParam(value = "id")String id, 
						//@RequestParam(value = "pwd")String pwd,
						//@RequestParam(value = "pwd")int pwd, //형 변환을 할 경우
						@RequestParam(value = "pwd", defaultValue = "111")int pwd, // 초기값을 주고(공백일 경우 111) 문자열을 숫자열로 형변환 시킴
						Model model) {
		
		String data = "";
		//if(id.equals("kor") && pwd.equals("111"))
		if(id.equals("kor") && pwd == 111) //클라이언트가 넘겨주는 모든 값은 다 string. 그래서 타입 미스매치 에러기 뜬다
			data = "로그인 성공";
		else 
			data = "로그인 실패";
		
		model.addAttribute("data", data);
		return "result";
	}
}
