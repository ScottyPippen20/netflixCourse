package com.company.SummativeAssessmentMahoneyScott.controller;

import com.company.SummativeAssessmentMahoneyScott.model.Answer;
import com.company.SummativeAssessmentMahoneyScott.model.quote;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(magicBallController.class)
public class magicBallControllerTest {
    @Autowired
    MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    private List<Answer> eightBallList;

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void shouldReturnAnswerOnPostRequest() throws Exception {

        Answer inputAnswer = new Answer();
        inputAnswer.setQuestion("How will my day go?");
        String inputJson = mapper.writeValueAsString(inputAnswer);
        mockMvc.perform(
                post("/magic")                            // Perform the POST request
                        .content(inputJson)                       // Set the request body
                        .contentType(MediaType.APPLICATION_JSON)  // Tell the server it's in JSON format
        )
                .andDo(print())                                // Print results to console
                .andExpect(status().isCreated());              // ASSERT (status code is 201)
    }
}
