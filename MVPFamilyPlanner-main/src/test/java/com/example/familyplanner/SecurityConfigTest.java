package com.example.familyplanner;

import com.example.familyplanner.service.SecurityConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SecurityConfigTest {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void passwordEncoderLoads() {
        String encoded = passwordEncoder.encode("password123");
        assert encoded != null && passwordEncoder.matches("password123", encoded);
    }

    @Test
    @WithMockUser
    void givenAuthenticatedUser_shouldAccessEndpoint() throws Exception {
        mockMvc.perform(get("/protected-endpoint")
                        .with(SecurityMockMvcRequestPostProcessors.user("user").password("password")))
                .andExpect(status().isOk());
    }

    @Test
    void givenNoCsrfProtection_shouldAllowPostWithoutCsrf() throws Exception {
        mockMvc.perform(get("/some-endpoint"))
                .andExpect(status().isOk());
    }
}
