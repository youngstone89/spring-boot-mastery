package com.youngstone.mastery.controller.example;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

// @SpringBootTest(classes = { ObjectValidController.class })
// @AutoConfigureMockMvc
@WebMvcTest(ObjectValidController.class)
public class ObjectValidControllerWebTest {

    @Autowired
    private ObjectValidController objectValidController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
        assertNotNull(objectValidController);
    }

    // @Test
    // void testCallTest1GetMapping() throws Exception {
    // mockMvc.perform(get("/v1/object/valid/test1"))
    // .andDo(print())
    // .andExpect(status().isBadRequest())
    // .andReturn();
    // }
}
