package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.JepumModel;


@Controller
public class JepumController {

	@Autowired
	private JepumModel jepumModel;
	
	@GetMapping("insdata")
	public String Method1() {
		return "redirect:input.html";
	}
	
	@PostMapping("insdata")
	public String Method2(JepumBean bean, Model model) {
		model.addAttribute("data", jepumModel.computePrice(bean));
		return "result";
	}
	
}
