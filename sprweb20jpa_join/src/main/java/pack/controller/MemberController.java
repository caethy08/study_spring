package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.dto.MemberDto;
import pack.service.MemberService;


@Controller
public class MemberController {
	@Autowired
	private MemberService mservice;
	
	@GetMapping("/member/mlist")
	public String getMethodName(Model model) {
		mservice.getList(model);  //return 하지 않은 void 타입 getList를 받아먹음. getList 내부에서 model.addattribute를 통해
		
		return "member/mlist";
	}
	//추가
	@GetMapping("/member/insertform")
	public String insertform() {
		return "/member/insertform";
	}
	
	@PostMapping("/member/insert")
	public String insert(MemberDto fbean) {
		mservice.insert(fbean);  //return 하지 않은 void 타입 getList를 받아먹음. 
		
		return "member/insert";
	}
	
	//회원 수정
	@GetMapping("/member/updateform")
	public String updateform(@RequestParam("num")  Long num, Model model) {//내부적으로 모델을 들고다니고 필요해서 사용
		mservice.getData(num, model);//dto로 변경된 것을 model에 담음
		return "/member/updateform";
	}
	
	@PostMapping("/member/update")
	public String update(MemberDto fbean) {
		//mservice.update(fbean);
		mservice.update2(fbean);
		return "/member/update";
	}
	
	//회원삭제
	@GetMapping("/member/delete")
	public String delete(@RequestParam("num") Long num) {
		mservice.delete(num);
		
		return "redirect:/member/mlist";
	}
	

}
