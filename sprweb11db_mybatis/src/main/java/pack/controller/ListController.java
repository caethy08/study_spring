package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.DataDao;
import pack.model.SangpumDto;


@Controller
public class ListController {
	@Autowired
	private DataDao dataDao;

	@GetMapping("mybatis")
	public String listProcess(Model model) {
		ArrayList<SangpumDto> list = (ArrayList<SangpumDto>)dataDao.getDataAll();
		model.addAttribute("datas", list); //datas(show.html)라는 키에 값을 줌
		return "show";
	}
	
	@GetMapping("search")
	public String SearchProcess(FormBean bean, Model model) {
		ArrayList<SangpumDto> list = (ArrayList<SangpumDto>)dataDao.getDataSearch(bean);
		model.addAttribute("datas", list); //datas(show.html)라는 키에 값을 줌
		return "show";
	}
	
	
}
