package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.DataDao;
import pack.model.MemberDto;


@Controller
public class DetailController {
	@Autowired
	private DataDao datadao;

	@GetMapping("detail")
	public String detailProcess(@RequestParam("id") String id, Model model) {
		MemberDto dto = datadao.getMemeber(id);
		model.addAttribute("member",dto);
		return "detail"; //detail.html을 부름
	}
	
}
