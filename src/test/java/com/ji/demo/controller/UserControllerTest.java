package com.ji.demo.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

public class UserControllerTest {
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    public void getUser() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.post("/users/1").accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
        mockMvc.perform(MockMvcRequestBuilders.post("/users/1").accept(MediaType.APPLICATION_JSON_UTF8));
    }
}
