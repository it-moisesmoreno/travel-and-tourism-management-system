package com.it_moisesmoreno.TourismAndTravelMS.controllers;

import java.util.ArrayList;
import java.util.List;

// UserController.java

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.it_moisesmoreno.TourismAndTravelMS.entities.User;
import com.it_moisesmoreno.TourismAndTravelMS.repositories.UserRepository;

@Controller
@RequestMapping("/usersWeb")
public class UserWebController {

  @Autowired
  private UserRepository userRepository;


  @GetMapping("/show")
  public String showUsersList(Model model) {
      List<User> listUsers = (List<User>) this.userRepository.findAll();
      model.addAttribute("listUsers", listUsers);
      return "users";
  }

  @GetMapping("/new")
  public String showNewForm(Model model) {
      model.addAttribute("user", new User());
      return "user_form";
  }

  @PostMapping("/save")
  public String saveUser(User user, RedirectAttributes ra) {
        this.userRepository.save(user);
        ra.addFlashAttribute("message", "The user has been saved successfully");
        return "redirect:/usersWeb/show";
  }

}
