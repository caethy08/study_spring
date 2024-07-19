package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import pack.model.DataDao;
import pack.model.Jikwon;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ListController {
	@Autowired
	private DataDao dataDao;
	
	@GetMapping("jikwon")
	public String list(FormBean bean, Model model) {
		ArrayList<Jikwon> slist = (ArrayList<Jikwon>)dataDao.getDataSearch(bean.getSearchValue());
		model.addAttribute("datas", slist);
		
		return "list";
	}
	
}
