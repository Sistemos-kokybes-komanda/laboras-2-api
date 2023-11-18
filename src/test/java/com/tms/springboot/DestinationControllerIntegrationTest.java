package com.tms.springboot;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tms.springboot.model.Destination;
import com.tms.springboot.repository.DestinationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class DestinationControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DestinationRepository destinationRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        destinationRepository.deleteAll();
    }

    @Test
    public void testCreateDestination() throws Exception {
        Destination destination = new Destination("Start", "End", LocalDate.now(), LocalDate.now().plusDays(1));

        mockMvc.perform(post("/createDestination")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(destination)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.startLocation").value(destination.getStartLocation()));
    }
}
