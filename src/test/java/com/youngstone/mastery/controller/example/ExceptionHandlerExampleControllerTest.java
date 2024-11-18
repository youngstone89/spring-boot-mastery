package com.youngstone.mastery.controller.example;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ExceptionHandlerExampleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ExceptionHandlerExampleController exampleController;

    @Test
    void contextLoads() throws Exception {
        assertNotNull(exampleController);
    }

    @Test
    void shouldReturnBadRequest_whenTest1IsHit() throws Exception {
        this.mockMvc.perform(get("/v1/exception-handle/example/test1"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();

    }

    @Test
    void shouldReturnInternalServerError_whenTest2IsHit() throws Exception {
        this.mockMvc.perform(get("/v1/exception-handle/example/test2"))
                .andDo(print())
                .andExpect(status().isInternalServerError())
                .andReturn();

    }
}
