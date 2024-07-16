package pack.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.JikDao;
import pack.model.JikDto;

@Controller
public class JikController {
	@Autowired
	private JikDao jikDao;
	
	@GetMapping("testdb")
	public String listProcess(@RequestParam(value="jikwon_jik")String jikwon_jik,
			Model model) {
		List<JikDto> list = jikDao.getJikList(jikwon_jik);
		
		model.addAttribute("list", list);
		return "list";
	}
}
