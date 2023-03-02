package com.sebastian.portfolio.controller;

import com.sebastian.portfolio.model.entities.User;
import com.sebastian.portfolio.model.repositories.UserRepository;
import com.sebastian.portfolio.payloads.AuthRequest;
import com.sebastian.portfolio.payloads.JwtResponse;
import com.sebastian.portfolio.security.JwtUtils;
import com.sebastian.portfolio.security.UserDetailsImplementation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final JwtUtils jwtUtils;

    @PostMapping("/api/auth/signin")
    public ResponseEntity<?> authenticate(@Valid @RequestBody AuthRequest request) {
        Authentication authentication;
        authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt;
        jwt = jwtUtils.generateJwt(authentication);
        UserDetailsImplementation userDetails;
        userDetails = (UserDetailsImplementation) authentication.getPrincipal();
        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername()));
    }

    @PostMapping("/api/auth/signup")
    public ResponseEntity<?> register(@Valid @RequestBody AuthRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            return ResponseEntity.badRequest().body("There is already a user with the name " + request.getUsername());
        } else {
            User user = new User(request.getUsername(), encoder.encode(request.getPassword()));
            userRepository.save(user);
            return ResponseEntity.ok("Success");
        }
    }

}
