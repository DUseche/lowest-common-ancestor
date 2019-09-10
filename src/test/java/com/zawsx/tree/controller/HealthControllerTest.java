package com.zawsx.tree.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by David Useche on 8/09/2019.
 */
@WebMvcTest(controllers = HealthController.class)
@AutoConfigureMockMvc
public class HealthControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void givenHealthCheck_ShouldResolve200Ok() throws Exception {
        mvc.perform(get("/health")).andExpect(status().isOk());
    }
}
