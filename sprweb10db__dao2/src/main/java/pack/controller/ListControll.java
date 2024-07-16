package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pack.model.DataDao;
import pack.model.MemberDto;


@Controller
public class ListControll {
	@Autowired
	private DataDao dataDao;

	@GetMapping("list")
	public String listprocess(Model model) {
		List<MemberDto> list = dataDao.getMemberList();
		
		model.addAttribute("list", list);
		return "list"; //list.html
	}
	
}
