package com.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HelloIntegrationTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void basicHelloWorld() throws Exception {
		// when
		String helloWorldRequest = "http://localhost:" + port + "/hello?message=Hello World";

		// then
		assertThat(this.restTemplate.getForObject(helloWorldRequest, String.class)).contains("Hello World");
	}
	
	@Test
    public void illegalCharsRequest() throws Exception {
        // when
        String helloWorldRequest = "http://localhost:" + port + "/hello?message=hi [^_^]";

        // then
        assertThat(this.restTemplate.getForObject(helloWorldRequest, String.class)).contains("[^_^]");
    }

}
