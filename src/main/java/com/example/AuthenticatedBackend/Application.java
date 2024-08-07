package com.example.AuthenticatedBackend;

import com.example.AuthenticatedBackend.models.Role;
import com.example.AuthenticatedBackend.models.User;
import com.example.AuthenticatedBackend.repository.RoleRepository;
import com.example.AuthenticatedBackend.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder){
		return args ->{

			// makes sure that if the admin isn't present that it automatically creates one
			// NB not to be used in production
			if (roleRepository.findByAuthority("ADMIN").isPresent()) return;

			Role adminRole = roleRepository.save(new Role("ADMIN"));
			roleRepository.save(new Role("USER"));

			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);
			String test = "test";
			User admin = new User(1, "admin", passwordEncoder.encode("password"), roles );

			userRepository.save(admin);
		};
	}


}
