package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.DataDao;
import pack.model.MemberDto;

@Controller
public class UpdateController {
	@Autowired
	private DataDao dataDao;
	
	@GetMapping("update")
	public String form(@RequestParam("id") String id, Model model) {
		MemberDto dto = dataDao.getMemeber(id);
		model.addAttribute("member",dto);
		return "update";
	}
	@PostMapping("update")
	public String update(MemberBean bean) {
		dataDao.upDate(bean);
		return "redirect:/list";
	}
}
