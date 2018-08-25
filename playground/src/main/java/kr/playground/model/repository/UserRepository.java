package kr.playground.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.playground.model.User;

public interface UserRepository extends JpaRepository<User, String> {

	User findByEmail(String email);

}
