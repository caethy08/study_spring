package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.BoardDao;

@Controller
public class DeleteController {
	@Autowired
	private BoardDao dao;
	
	@GetMapping(value = "delete")
	public String deleteSummit(@RequestParam("num") int num, Model model){
		String str = dao.deleteData(num);
		
		if(str.equals("success")) {
			return "redirect:/list";
		}else {
			return "error";
			
		}
		
	}
}
