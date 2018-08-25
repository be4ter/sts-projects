package kr.playground.model;

import java.time.LocalDateTime;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCrypt;

import kr.playground.exception.SignUpException;

@Entity
@Table(name = "usr")
public class User {

	@Id
	private String email;
	private String password;
	private LocalDateTime createTime;
	private LocalDateTime lastLoginTime;
	private LocalDateTime lastLogoutTime;
	private Long authNumber;
	private boolean auth;

	public User() {

	}

	public User(String email, String password, String passwordCheck) throws SignUpException {
		super();
		if (!veryfiedUserInfo(email, password, passwordCheck)) {
			throw new SignUpException();
		}
		this.email = email;
		this.password = BCrypt.hashpw(password, BCrypt.gensalt(12));
		this.createTime = LocalDateTime.now();
		Random random = new Random();
		random.setSeed(System.currentTimeMillis());
		this.authNumber = random.nextLong();
		this.auth = false;
	}

	private boolean veryfiedUserInfo(String email, String password, String passwordCheck) throws SignUpException {
		emptyValue(email);
		emptyValue(password);
		emptyValue(passwordCheck);
		return password.equals(passwordCheck);
	}

	private boolean emptyValue(String value) throws SignUpException {
		if (value == null || value.equals("")) {
			throw new SignUpException();
		}
		return false;
	}

	public String getEmail() {
		return email;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public LocalDateTime getLastLoginTime() {
		return lastLoginTime;
	}

	public LocalDateTime getLastLogoutTime() {
		return lastLogoutTime;
	}

	public void setLastLoginTime(LocalDateTime lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public void setLastLogoutTime(LocalDateTime lastLogoutTime) {
		this.lastLogoutTime = lastLogoutTime;
	}

	public boolean verifyPassword(String password) throws SignUpException {
		if (!BCrypt.checkpw(password, this.password)) {
			throw new SignUpException();
		}
		return true;
	}

	public void setLastLoginTime() {
		this.lastLoginTime = LocalDateTime.now();
	}

	public void setLastLogoutTime() {
		this.lastLogoutTime = LocalDateTime.now();
	}

	public Long getNumber() {
		return authNumber;
	}

	public boolean isVerifyAuthNumber(Long number) throws SignUpException {
		if (this.auth) {
			throw new SignUpException();
		}
		if (this.authNumber.equals(number)) {
			return this.auth = true;
		}
		throw new SignUpException();
	}

	public boolean verifyAuth() throws SignUpException {
		if (!this.auth) {
			throw new SignUpException();
		}
		return true;
	}
}
