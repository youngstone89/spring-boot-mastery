package com.youngstone.mastery.controller.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.youngstone.mastery.advice.GlobalExceptionHandler;
import com.youngstone.mastery.model.ProductRequestV1;

@SpringBootTest(classes = { ProductController.class, GlobalExceptionHandler.class })
@AutoConfigureMockMvc
public class ProductControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @Autowired
        private ProductController productController;

        @Autowired
        private GlobalExceptionHandler globalExceptionHandler;

        @BeforeEach
        void setup() {
                mockMvc = MockMvcBuilders.standaloneSetup(productController)
                                .setControllerAdvice(globalExceptionHandler).build();
        }

        @Test
        void contextLoads() {
                assertNotNull(mockMvc);
                assertNotNull(productController);
                assertNotNull(globalExceptionHandler);
        }

        @Test
        void testAddProduct() throws Exception {
                ObjectMapper mapper = new ObjectMapper();
                String jsonContent = mapper
                                .writeValueAsString(new ProductRequestV1("youngstone product", "Electronics",
                                                "youngstone"));
                mockMvc.perform(MockMvcRequestBuilders.post("/v1/product/").contentType(MediaType.APPLICATION_JSON)
                                .content(jsonContent))
                                .andExpect(MockMvcResultMatchers.status().isCreated())
                                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                                .andDo(MockMvcResultHandlers.print());
        }

        @Test
        void testAddProduct_throwBadRequestException() throws Exception {
                ObjectMapper mapper = new ObjectMapper();
                String jsonContent = mapper.writeValueAsString(new ProductRequestV1("", "Electronics", "kys"));
                MvcResult result = mockMvc
                                .perform(MockMvcRequestBuilders.post("/v1/product/")
                                                .contentType(MediaType.APPLICATION_JSON)
                                                .content(jsonContent))
                                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                                .andDo(MockMvcResultHandlers.print()).andReturn();

                Class<? extends Exception> exception = result.getResolvedException().getClass();
                assertEquals(MethodArgumentNotValidException.class, exception);
                MockHttpServletResponse response = result.getResponse();
                String content = response.getContentAsString();
                System.out.println(content);
                // default message structure
                // {"type":"about:blank","title":"Bad Request","status":400,"detail":"Invalid
                // request content.","instance":"/v1/product/"}

        }

        @Test
        void testAddProduct_throwBadRequestException_onClassValidator() throws Exception {
                ObjectMapper mapper = new ObjectMapper();
                String jsonContent = mapper
                                .writeValueAsString(new ProductRequestV1("", "Electronics",
                                                "youngstone"));
                MvcResult result = mockMvc
                                .perform(MockMvcRequestBuilders.post("/v1/product/")
                                                .contentType(MediaType.APPLICATION_JSON)
                                                .content(jsonContent))
                                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                                .andDo(MockMvcResultHandlers.print()).andReturn();

                Class<? extends Exception> exception = result.getResolvedException().getClass();
                assertEquals(MethodArgumentNotValidException.class, exception);
                MockHttpServletResponse response = result.getResponse();
                String content = response.getContentAsString();
                System.out.println(content);
                // default message structure
                // {"type":"about:blank","title":"Bad Request","status":400,"detail":"Invalid
                // request content.","instance":"/v1/product/"}

        }
}
