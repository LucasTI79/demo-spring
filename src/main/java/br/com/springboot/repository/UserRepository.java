package br.com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.springboot.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
  
  public List<User> findByUsername(String username);

}
