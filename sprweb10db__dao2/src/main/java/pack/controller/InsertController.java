package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pack.model.DataDao;

@Controller
public class InsertController {
	@Autowired
	private DataDao dataDao;
	
	@GetMapping("insert")
	public String form() {
		return "insertform";
	}
	@PostMapping("insert")
	public String submit(MemberBean bean) {
		dataDao.insData(bean);
		return "redirect:/list"; //(forwarding은)옛날 내용이 나타남. > redirect로 불라와야지 추가후 목록 보기가 됨
	}
}
