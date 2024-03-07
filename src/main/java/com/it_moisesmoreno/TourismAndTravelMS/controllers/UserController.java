package com.it_moisesmoreno.TourismAndTravelMS.controllers;

import java.util.ArrayList;
import java.util.List;

// UserController.java

import java.util.Optional;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.it_moisesmoreno.TourismAndTravelMS.entities.User;
import com.it_moisesmoreno.TourismAndTravelMS.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

  private UserRepository userRepository;

  public UserController(final UserRepository userRepository) {
      this.userRepository = userRepository;
    }

  @GetMapping("/search")
  public List<User> searchUsers(
  @RequestParam(name="isUser", required = false) Boolean isUser,
  @RequestParam(name="username", required = false) String username,
  @RequestParam(name="email", required = false) String email,
  @RequestParam(name="isActive", required = false) Boolean isActive
  ) {
      if (username != null && email != null) {
        return this.userRepository.findByUsernameAndEmail(username, email);
      }
      if (username != null) {
        return this.userRepository.findByUsernameOrEmail(username, "");
      }
      if (email != null) {
        return this.userRepository.findByUsernameOrEmail("", email);
      }
      if (isUser != null && isUser) {
        return this.userRepository.findByRole(User.Role.user);
      }
      if (isUser != null && !isUser) {
        return this.userRepository.findByRole(User.Role.admin);
      }
      if (isActive != null && isActive) {
        return this.userRepository.findByIsActiveTrue();
      }
      if (isActive != null && !isActive) {
        return this.userRepository.findByIsActiveFalse();
      }

      return new ArrayList<>();
    }
      


  @GetMapping
  public Iterable<User>  getAllUsers() {
      return this.userRepository.findAll();
  }

  @GetMapping("/{id}")
  public Optional<User>  getUserById(@PathVariable("id") Integer id) {
      return this.userRepository.findById(id);
  }

  @PostMapping()
  public User createNewUser(@RequestBody User user){
    User newUser = this.userRepository.save(user);
    return newUser;
  }

  @PutMapping("/{id}")
  public User updateUser (@PathVariable("id") Integer id, 
  @RequestBody User u){
    Optional<User> userToUpdateOptional = this.userRepository.findById(id);
    if(!userToUpdateOptional.isPresent()){
      return null;
    }
    User userToUpdate = userToUpdateOptional.get();

    if(u.getUsername() != null){
      userToUpdate.setUsername(u.getUsername());
    }
    if(u.getPassword() != null){
      userToUpdate.setPassword(u.getPassword());
    }
    if(u.getEmail() != null){
      userToUpdate.setEmail(u.getEmail());
    }
    if(u.getRole() != null){
      userToUpdate.setRole(u.getRole());
    }

    User updatedUser = this.userRepository.save(userToUpdate);
    return updatedUser;
  }

  @DeleteMapping("/{id}")
  public User deleteUser(@PathVariable("id") Integer id) {
    Optional<User> userToDeleteOptional = this.userRepository.findById(id);
    if (!userToDeleteOptional.isPresent()) {
      return null;
    }
    User userToDelete = userToDeleteOptional.get();
    this.userRepository.delete(userToDelete);
    return userToDelete;
  }
}
