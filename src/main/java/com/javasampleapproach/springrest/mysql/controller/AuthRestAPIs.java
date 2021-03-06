//package com.javasampleapproach.springrest.mysql.controller;
//
//
//import com.javasampleapproach.springrest.mysql.message.request.LoginForm;
//import com.javasampleapproach.springrest.mysql.message.request.SignUpForm;
//import com.javasampleapproach.springrest.mysql.message.response.JwtResponse;
//import com.javasampleapproach.springrest.mysql.message.response.MessageSeo;
//import com.javasampleapproach.springrest.mysql.message.response.RapportAnalyse;
//import com.javasampleapproach.springrest.mysql.message.response.ResponseMessage;
//import com.javasampleapproach.springrest.mysql.model.Role;
//import com.javasampleapproach.springrest.mysql.model.RoleName;
//import com.javasampleapproach.springrest.mysql.repo.RoleRepository;
//import com.javasampleapproach.springrest.mysql.repo.UserRepository;
//import com.javasampleapproach.springrest.mysql.security.jwt.JwtProvider;
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.springframework.beans.factory.annotation.Autowired;
//import com.javasampleapproach.springrest.mysql.model.User;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//
//import java.io.IOException;
//import java.util.HashSet;
//import java.util.Set;
//
//@CrossOrigin(origins = "*", maxAge = 3600)
//@RestController
//@RequestMapping("/api/auth")
//public class AuthRestAPIs {
//
////	@Autowired
////	AuthenticationManager authenticationManager;
//
//	@Autowired
//	UserRepository userRepository;
//
//	@Autowired
//	RoleRepository roleRepository;
//
//	@Autowired
//	PasswordEncoder encoder;
//
//	@Autowired
//	JwtProvider jwtProvider;
//
//	@PostMapping("/signin")
//	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {
////
////		Authentication authentication = authenticationManager.authenticate(
////				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
////
////		SecurityContextHolder.getContext().setAuthentication(authentication);
////
////		String jwt = jwtProvider.generateJwtToken(authentication);
////		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//
////		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
//		
//		return ResponseEntity.ok(new JwtResponse(null, null, null));
//	}
//
//
//	@PostMapping("/signup")
//	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
//		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
//			return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
//					HttpStatus.BAD_REQUEST);
//		}
//
//		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
//			return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"),
//					HttpStatus.BAD_REQUEST);
//		}
//
//		// Creating user's account
//		User user = new User(signUpRequest.getName(), signUpRequest.getUsername(), signUpRequest.getEmail(),
//				encoder.encode(signUpRequest.getPassword()));
//
//		Set<String> strRoles = signUpRequest.getRole();
//		Set<Role> roles = new HashSet<>();
//
//		strRoles.forEach(role -> {
//			switch (role) {
//			case "admin":
//				Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
//						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
//				roles.add(adminRole);
//
//				break;
//			case "pm":
//				Role pmRole = roleRepository.findByName(RoleName.ROLE_PM)
//						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
//				roles.add(pmRole);
//
//				break;
//			default:
//				Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
//						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
//				roles.add(userRole);
//			}
//		});
//
//		user.setRoles(roles);
//		userRepository.save(user);
//
//		return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
//	}
//}