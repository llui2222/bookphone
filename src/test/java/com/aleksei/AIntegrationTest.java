package com.aleksei;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class AIntegrationTest {
    protected static final String RESOURCE_URL = "/v1/phones";

    @Autowired
    MockMvc mockMvc;
}
