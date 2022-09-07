package in.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.project.Entity.User;
import in.project.Service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	
	@GetMapping("/")
	public String register(Model model) {
		User user=new User();
		model.addAttribute("user",user);
		return "register";
	}
	
	@PostMapping("/registerUser")
	public String registerUser(@ModelAttribute("user") User user) {
		String result="error";
		System.out.println(user);
		if(user.getPassword().equals(user.getCpassword())) {
			try {
				System.out.println("hiii1");

				service.registerUser(user);
				System.out.println("hiii");
				result= "home";
				System.out.println("hiii2");


			}
			catch(Exception e) {
				System.out.println("hiii catch");

				result= "home";
			}
		}
		return "result";
	}

}
