package com.example;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author Deyne Dirk
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest({HelloController.class})
public class HelloControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void helloWorldTest() throws Exception {
		mockMvc.perform(get("/hello").param("message", "Hello World!"))
		       .andDo(print()).andExpect(status().isOk())
			   .andExpect(content().string(containsString("Hello World")));
	}
	
	@Test
    public void illeagalCharsTest() throws Exception {
        mockMvc.perform(get("/hello").param("message", "hi [^_^]"))
               .andDo(print()).andExpect(status().isOk())
               .andExpect(content().string(containsString("[^_^]")));
    }
}
