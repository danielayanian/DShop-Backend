package ar.danielayanian.dshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import ar.danielayanian.dshop.entities.User;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value = "select * from user where email = ?1", nativeQuery = true)
    Optional<User> findByEmail(String email);
	
	
}
