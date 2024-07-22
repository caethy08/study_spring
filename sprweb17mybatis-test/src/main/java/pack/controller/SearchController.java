package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import pack.model.JikwonDao;
import pack.model.JikwonDto;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SearchController {
	@Autowired
	private JikwonDao dao;
	
	@RequestMapping("search")
	public String search(Model model, @RequestParam("buser_num")int buser_num,  @RequestParam("jikwon_rating")String jikwon_rating) {
		List<JikwonDto> slist = dao.list(buser_num, jikwon_rating);
		model.addAttribute("list", slist);
		return "list";
	}
	
}
