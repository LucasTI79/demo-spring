package br.com.springboot.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.models.User;
import br.com.springboot.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @GetMapping
  public ResponseEntity<List<User>> user(){
    return new ResponseEntity<List<User>>(userRepository.findAll(), HttpStatus.OK); 
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> user(@PathVariable Long id){
    Optional<User> userFind = this.userRepository.findById(id);

    if(userFind.isPresent()){
      return ResponseEntity.ok().body(userFind.get());
    }

    return ResponseEntity.noContent().build(); 
  }


  @PostMapping
  public User user(@RequestBody User user){
    List<User> usernameAlreadyExists = this.userRepository.findByUsername(user.getUsername());

    if(!usernameAlreadyExists.isEmpty()){
      return null;
    }

    userRepository.save(user);
    return user;
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> delete(@PathVariable Long id){
    this.userRepository.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
