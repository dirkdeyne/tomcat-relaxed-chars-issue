package com.example;

import org.springframework.boot.web.embedded.tomcat.ConfigurableTomcatWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TomcatConfiguration {
  
  @Bean
  public RelaxtedQueryCharsCustomizer relaxedCharsCustomizer() {
    return new RelaxtedQueryCharsCustomizer();
  }
  
  @Bean
  public RelaxtedPathCharsCustomizer relaxtedPathCharsCustomizer() {
    return new RelaxtedPathCharsCustomizer();
  }
 
  private class RelaxtedQueryCharsCustomizer implements WebServerFactoryCustomizer<ConfigurableTomcatWebServerFactory> {

    @Override
    public void customize(ConfigurableTomcatWebServerFactory factory) {
      factory.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> {
              connector.setAttribute("relaxedQueryChars", "[\\]^`{|}");
      });
    }
  }

  
  private class RelaxtedPathCharsCustomizer implements WebServerFactoryCustomizer<ConfigurableTomcatWebServerFactory> {

    @Override
    public void customize(ConfigurableTomcatWebServerFactory factory) {
      factory.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> {
              connector.setAttribute("relaxedPathChars", "[\\]^`{|}");
      });
    }
  }

}
