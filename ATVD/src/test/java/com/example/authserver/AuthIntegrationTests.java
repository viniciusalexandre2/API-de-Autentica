package com.example.authserver;

import com.example.authserver.model.User;
import com.example.authserver.repository.UserRepository;
import com.example.authserver.service.JwtService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @BeforeEach
    void setup() {
        if (userRepository.findByUsername("admin").isEmpty()) {
            userRepository.save(new User(null, "admin", passwordEncoder.encode("123456"), "ADMIN"));
        }
        if (userRepository.findByUsername("user").isEmpty()) {
            userRepository.save(new User(null, "user", passwordEncoder.encode("password"), "USER"));
        }
    }

    @Test
    void testLoginSuccess() throws Exception {}
    // Demais testes conforme scaffold acima...
}
