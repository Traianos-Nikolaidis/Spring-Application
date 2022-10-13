package com.example.traianos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.ui.Model;

@Controller

public class MainController {

    @Autowired
    private UserRepository userRepository;
     
    @RequestMapping("")
    public String viewHomePage() {
        return "homepage";
    }
	
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }
    
    @PostMapping(path="/add") 
    public String addNewUser (@RequestParam String name, @RequestParam String surname, @RequestParam String email, @RequestParam String gender, @RequestParam String date, @RequestParam String ha, @RequestParam String wa) {
    	
      User n = new User();

      n.setName(name);
      n.setSurname(surname);
      n.setEmail(email);
      n.setGender(gender);
      n.setDate(date);
      n.setha(ha);
      n.setwa(wa);
      userRepository.save(n);
      return "homepage";
    }
    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
      return userRepository.findAll();
    }
    
    @GetMapping(path="/unique")
    public @ResponseBody User getall(@RequestParam Integer newid) {
    	return userRepository.findUserById(newid);
    }
    
    @RequestMapping(path="/display")
    public String displayAll() {
        return "display";
    }
}