package kr.playground.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.playground.model.User;
import kr.playground.model.repository.UserRepository;

@RestController
@RequestMapping("/api/user")
public class ApiUserController {
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/{email}")
	public User user(@PathVariable String email) {
		return userRepository.findByEmail(email);
	}
}
