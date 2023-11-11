package com.RecipeBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MessegeController {
	
	
	@Autowired
	MailService mailService;

	@GetMapping("/contact-us")
	public String contactus(Model model) {
	Messege messege = new Messege();
	model.addAttribute("messege", messege);
		
	return "contact";
	}
	
	@PostMapping("/contact-us")
	public String sendmessege(@ModelAttribute("messege") Messege messege) throws Exception {
		String content = "Name: " + messege.getName();
		content += "<br>Email: " + messege.getEmail();
		content += "<br> Messege:" + messege.getMessege();
		mailService.send(messege.getEmail(), "recipe871@gmail.com", messege.getSubject(), content);
		return "redirect:/";
		
		
	}
	
	
	
	
	
	

}
