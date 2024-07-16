package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import pack.model.DataDao;
import pack.model.JikwonDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class JikController {
	@Autowired
	private DataDao dataDao;
	
	@GetMapping("testdb")
	public String listProcess(@RequestParam(value="jikwon_jik")String jikwon_jik,
			Model model) {
		ArrayList<JikwonDto> list = dataDao.selectAll(jikwon_jik);
		model.addAttribute("datas", list);
		return "list";
	}
	
}
