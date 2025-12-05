package com.example.ecom.kyc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class KycServiceIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCheckCustomer() throws Exception {
        mockMvc.perform(post("/api/kyc/check")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"customerId\":123}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.status").value("ALLOW"));
    }
}
