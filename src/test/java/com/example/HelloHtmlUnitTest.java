package com.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;
import org.springframework.web.context.WebApplicationContext;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { TomcatIllegalCharApplication.class })
public class HelloHtmlUnitTest {

	private WebClient webClient;
	
	@Autowired
    private WebApplicationContext wac;
	  
	@Before
    public void setup() {
        webClient = MockMvcWebClientBuilder
          .webAppContextSetup(wac).build();
    }

	@Test
	public void helloWorldRequest() throws Exception {
		// given
		String text = "Hello world!";

		// when
		String url = "http://localhost:8080/hello?message=" + text;
		HtmlPage hello = webClient.getPage(url);

		// then
		assertThat(hello.asText()).contains(text);
	}

	@Test
	public void illegalCharsRequest() throws Exception {
		// given
		String text = "Hi [^.^]";

		// when
		String url = "http://localhost:8080/hello?message=" + text;
		HtmlPage hello = webClient.getPage(url);

		// then
		assertThat(hello.asText()).contains(text);
	}

}
