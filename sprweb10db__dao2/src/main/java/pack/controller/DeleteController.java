package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.DataDao;
import pack.model.MemberDto;

@Controller
public class DeleteController {
	@Autowired
	private DataDao dataDao;
	
	@GetMapping("delete")
	public String delete(@RequestParam("id") String id) {
		dataDao.delDate(id);
		return "redirect:/list";
	}
}
