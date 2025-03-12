package com.codewithrekik.marketplace;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
/**
 * This class contains integration tests for the Marketplace application.
 * It tests the user registration endpoint by sending a POST request to the /users/register URL.
 * It verifies that the endpoint returns a 200 OK status code.
 */
@SpringBootTest
@AutoConfigureMockMvc
class MarketplaceApplicationTests {

    @Autowired
    private MockMvc mockMvc; // MockMvc is used to send HTTP requests in tests

    @Test
    void testRegisterUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\": \"testuser\", \"email\": \"test@example.com\", \"password\": \"password\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}