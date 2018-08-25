package kr.playground.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import kr.playground.exception.SignUpException;
import kr.playground.model.User;
import kr.playground.model.repository.UserRepository;

@Controller
public class UserController {
	@Autowired
	UserRepository userRepository;

	@Autowired
	private MailSender sender;

	@GetMapping("/auth/{number}/{email}")
	public String auth(@PathVariable Long number, @PathVariable String email) {
		User user = userRepository.findByEmail(email);
		try {
			user.isVerifyAuthNumber(number);
		} catch (SignUpException e) {
			e.printStackTrace();
			return "accountFaild";
		}
		userRepository.save(user);
		return "accountSuccess";
	}

	@PostMapping("/signup")
	public String create(String email, String password, String passwordCheck) {
		User user = null;
		try {
			user = userRepository.save(new User(email, password, passwordCheck));
		} catch (SignUpException e) {
			e.printStackTrace();
			return "faild";
		}

		sendMail(email, user);
		return "success";
	}

	@PostMapping("/signin")
	public String signin(String email, String password, HttpSession httpSession) {
		User user = userRepository.findByEmail(email);
		try {
			user.verifyPassword(password);
			user.verifyAuth();
		} catch (SignUpException e) {
			e.printStackTrace();
			return "faild";
		}
		user.setLastLoginTime();
		httpSession.setAttribute("loginedUser", user);
		userRepository.save(user);
		return "redirect:/";
	}

	@PostMapping("/signout")
	public String signout(HttpSession httpSession) {
		User user = (User) httpSession.getAttribute("loginedUser");
		user.setLastLogoutTime();
		userRepository.save(user);
		httpSession.removeAttribute("loginedUser");
		return "redirect:/";
	}

	public void sendMail(String email, User user) {
		String message = "http://localhost:8080/auth/" + user.getNumber() + "/" + email;
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom("sender email"); // sender email
		msg.setTo("receiver email"); // receive email
		msg.setSubject("Send mail from Spring Boot"); // title
		msg.setText(message); // contents
		this.sender.send(msg);
	}

}
