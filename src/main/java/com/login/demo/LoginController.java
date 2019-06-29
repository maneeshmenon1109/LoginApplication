package com.login.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.reusable.CommonMethods;

@Controller
@RequestMapping("login")
public class LoginController {

    @GetMapping
    public String loginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping
    public String loginSubmit(@ModelAttribute User user) {
     
    	String role=CommonMethods.loginValidator(user.getId(),user.getUserPassword());
    	
    	if (!role.contains("Error"))
    	{
    		user.setRole(role);
    		return "result";
    	}
    	else
    	{
    		user.setMessage(role);
    		return "login";
    		
    	}
    }
    
    
    

}
