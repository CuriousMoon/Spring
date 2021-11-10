package springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/home")
	public String home()
	{
		System.out.println("This is home URL");
		return "index";
	}
	
	@RequestMapping("/about")
	public String about()
	{
		return "about";
	}
	
	@RequestMapping("/services")
	public String services()
	{
		return "services";
	}
	
	@RequestMapping("/help")
	public String help(){
		return "help";
	}

}
